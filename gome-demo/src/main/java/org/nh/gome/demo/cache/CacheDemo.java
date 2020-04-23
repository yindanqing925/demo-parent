package org.nh.gome.demo.cache;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: CacheDemo.java
 * @description:
 * @author: yindanqing
 * @create: 2020/4/23 15:35
 */
public class CacheDemo {

    public static void main(String[] args) throws InterruptedException {
        test2();
    }


    private static void test(){
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "Java", 1);
        System.out.println(cache.get(1));// Java
        cache.remove(1);
        System.out.println(cache.get(1));// null
        cache.put(2,"C++", 2);
        cache.put(3,"Python", 3);
        System.out.println(cache.get(2));//C++
        cache.put(4,"C", 4);
        cache.put(5,"PHP", 5);
        System.out.println(cache.get(2));// C++
    }

    private static void test2() throws InterruptedException {
        int threadNum = 10;
        int batchSize = 10;
        LRUCache<Integer, Integer> cache = new LRUCache<>(batchSize * 5);
        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        long startTime = System.currentTimeMillis();
        for (int t = 0; t < threadNum; t++) {
            executorService.submit(() -> {
                for (int i = 0; i < batchSize; i++){
                    int count = atomicInteger.incrementAndGet();
                    cache.put(count, count, count);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("Cache size:" + cache.size());//Cache size:100
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Time cost:"+duration);//Time cost：511ms
        System.out.println(atomicInteger.get());
    }


}
