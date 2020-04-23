package org.nh.gome.demo.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @program: CountDownLatchDemo.java
 * @description: CountDownLatch示例, 简称发令枪
 * @author: yindanqing
 * @create: 2020/4/23 17:27
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        int threadNum = 10;
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++){
            threadPool.submit(() -> {
                System.out.println("start" + System.currentTimeMillis());
                countDownLatch.countDown();
            });
        }
        System.out.println("loop end");
        countDownLatch.await();
        System.out.println("thread end");
        threadPool.shutdown();
        System.out.println("threadPool end");

    }

}
