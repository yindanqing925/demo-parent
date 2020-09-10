package org.nh.gome.demo.concurrent.keyword;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class VolatileAndCountDownDemo {

    private static final int THREAD_NUM = 10;
    public static final int SIZE = 100000;

    public static volatile int count = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);
        List<Thread> list = new ArrayList<>(THREAD_NUM + (THREAD_NUM >> 1) + 1);
        for (int i = 0; i < THREAD_NUM; i++) {
            Thread thread;
            if (i % 2 == 0) {
                thread = new Thread(() -> {
                    System.out.println(Thread.currentThread().getName() + " start" + count);
                    for (int j = 1; j <= SIZE; j++) {
                        count--;
                    }
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName() + " end" + count);
                });
            } else {
                thread = new Thread(() -> {
                    System.out.println(Thread.currentThread().getName() + " start" + count);
                    for (int j = 1; j <= SIZE; j++) {
                        count++;
                    }
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName() + " end" + count);
                });
            }
            thread.start();
            list.add(thread);
        }
        System.out.println("all thread start");
        countDownLatch.await();
        for (int i = 0; i < THREAD_NUM; i++) {
            while(list.get(i).isAlive()){
            }
        }
        System.out.println(count);
        System.out.println("all thread end");

    }

}
