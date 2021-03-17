package com.checkpeng.javademo.lock.threadsign;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 多个线程交替打印到1002 {

    private volatile static int count = 0;

    private static ReentrantLock lock = new ReentrantLock(true);

    private volatile static int state = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                while (count < 100) {
                    lock.lock();
                    int now = finalI;
                    Thread.currentThread().setName(String.valueOf(now));
                    if (state == now) {
                        System.out.println(Thread.currentThread().getName() + "线程打印了：" + count);
                        count++;
                        state = (++state) % 3;
                    }
                    lock.unlock();
                }
            });
            thread.start();
        }
        Thread.sleep(1000);
    }
}
