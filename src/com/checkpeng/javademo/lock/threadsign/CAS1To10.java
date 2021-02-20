package com.checkpeng.javademo.lock.threadsign;

import java.util.concurrent.atomic.AtomicInteger;

public class CAS1To10 {

    public volatile static boolean flag = false;

    private static AtomicInteger numA = new AtomicInteger();
    private static AtomicInteger numB = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(() -> {
            while (numA.get() < 10) {
                if (!flag) {
                    System.out.println(Thread.currentThread().getName()
                            + "----" + (numA.incrementAndGet()));
                    flag = true;
                }
                //   latch.countDown();

            }
        });

        Thread B = new Thread(() -> {
            while (numB.get() < 10) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName()
                            + "----" + (numB.incrementAndGet()));
                    flag = false;
                }
                //	latch.countDown();

            }
        });
        A.start();
        B.start();
        A.join();
        B.join();
    }
}
