package com.checkpeng.javademo.lock.threadsign;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 多个线程交替打印到100 {

    private volatile static int i = 0;

    private static ReentrantLock lock = new ReentrantLock(true);

    private static Condition[] conditions = {lock.newCondition(), lock.newCondition(), lock.newCondition()};

    private volatile static int state = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 3; j++) {
            int finalJ = j;
            Thread thread = new Thread(() -> {
                Thread.currentThread().setName(String.valueOf(finalJ));
                while (i < 100) {
                    lock.lock();
                    if (state != finalJ) {
                        try {
                            conditions[finalJ].await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + i);
                        i = ++i;
                        state = i % 3;
                        conditions[state].signal();
                    }
                }
                for (int k = 0; k < conditions.length; k++) {
                    conditions[k].signal();
                }
            });
            thread.start();
        }
        Thread.sleep(1000);
    }
}
