package com.checkpeng.javademo.lock.threadsign;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1To100 {

    private volatile static int i = 0;

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    private volatile static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            while (i <= 100) {
                lock.lock();
                try {
                    if (flag) {
                        condition.await();
                    } else {
                        System.out.println(Thread.currentThread().getName()
                                + "----" +(i++));
                        flag = true;
                        condition.signal();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread b = new Thread(() -> {
            while (i <= 100) {
                lock.lock();
                try {
                    if (!flag) {
                        condition.await();
                    } else {
                        System.out.println(Thread.currentThread().getName()
                                + "----" +(i++));
                        flag = false;
                        condition.signal();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    lock.unlock();
                }
            }
        });
        a.start();
        b.start();
        a.join();
        b.join();
    }
}
