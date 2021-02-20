package com.checkpeng.javademo.lock.threadsign;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替打印0-100
 */
public class JavaLock1To100 {

    private volatile static int i = 0;

    private static byte[] lock = new byte[0];

    private volatile static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            while (i <= 100) {
                synchronized (lock) {
                    if (flag) {
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName()
                                + "----" + (i++));
                        flag = true;
                        lock.notifyAll();
                    }

                }
            }
        });
        Thread b = new Thread(() -> {
            while (i <= 100) {
                synchronized (lock) {
                    if (!flag) {
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName()
                                + "----" + (i++));
                        flag = false;
                        lock.notifyAll();
                    }

                }
            }
        });
        a.start();
        b.start();
        a.join();
        b.join();
    }
}
