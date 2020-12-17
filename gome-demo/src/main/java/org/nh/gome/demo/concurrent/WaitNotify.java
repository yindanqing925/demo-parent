package org.nh.gome.demo.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @program: WaitNotify.java
 * @description: 并发编程中摘抄的wait-notify示例
 * @author: yindanqing
 * @create: 2020/12/15 15:25
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();
    public static void main(String[] args) throws Exception {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
        /**
         * 预测输出
         * Thread[WaitThread,5,main] flag is true. wait @ 15:32:09
         * Thread[NotifyThread,5,main] hold lock. notify @ 15:32:10
         * Thread[NotifyThread,5,main] hold lock again. sleep @ 15:32:15
         * Thread[WaitThread,5,main] flag is false. running @ 15:32:20
         */
    }
    static class Wait implements Runnable {
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                // 当条件不满足时，继续wait，同时释放了lock的锁
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        // wait方法会将当前线程变为等待状态, 并加入等待队列, 释放sync获得的对象锁
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                // 条件满足时，完成工作
                System.out.println(Thread.currentThread() + " flag is false. running @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }
    static class Notify implements Runnable {
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized (lock) {
                // 获取lock的锁，然后进行通知，通知时不会释放lock的锁，
                // 直到当前线程释放了lock后，WaitThread才能从wait方法中返回
                System.out.println(Thread.currentThread() + " hold lock. notify @ " +
                        new SimpleDateFormat("HH:mm:ss").format(new Date()));
                // notifyAll方法会通知所有在等待队列上的thread, 迁移至同步队列, 等待Monitor.exit后进行锁竞争, 但直到sync代码块结束才会释放sync获得的对象锁
                lock.notifyAll();
                flag = false;
                sleep();
            }
            // 再次加锁, 这里将会和上面Wait中的代码块一同竞争锁, 所以, 对于63L的输出和44L的输出, 这两者的顺序是不定的
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                sleep();
            }
        }
    }

    private static void sleep(){
        try {
            Thread.sleep(1*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
