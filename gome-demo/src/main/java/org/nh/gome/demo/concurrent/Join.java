package org.nh.gome.demo.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @program: Join.java
 * @description: 并发编程中摘抄的join示例
 * @author: yindanqing
 * @create: 2020/12/15 16:40
 */
public class Join {

    public static void main(String[] args) throws Exception {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            // 每个线程拥有前一个线程的引用，需要等待前一个线程终止，才能从等待中返回
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        System.out.println(Thread.currentThread().getName() + " sleep.");
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    /**
     * // 加锁当前线程对象
     * public final synchronized void join() throws InterruptedException {
     * // 条件不满足，继续等待
     * while (isAlive()) {
     * wait(0);
     * }
     * // 条件符合，方法返回
     * }
     */

    static class Domino implements Runnable {

        private final Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}