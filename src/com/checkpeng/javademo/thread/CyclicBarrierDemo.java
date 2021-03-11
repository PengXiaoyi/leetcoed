package com.checkpeng.javademo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
        for (int i = 0; i < 4; i++) {
            Thread test = new Thread(() -> {
                System.out.println("线程开始运行" + Thread.currentThread().getName());
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("所有线程就绪完毕");
            });
            test.start();
        }
        Thread.sleep(111111);
    }
}
