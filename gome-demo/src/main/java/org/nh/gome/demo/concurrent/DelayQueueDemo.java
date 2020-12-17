package org.nh.gome.demo.concurrent;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @program: DelayQueueDemo.java
 * @description: 延迟队列Demo, 延时队列可应用于缓存系统的设计(过期的自动填补), 定时调度任务
 * @author: yindanqing
 * @create: 2020/12/17 17:00
 */
public class DelayQueueDemo {

    public static void main(String[] args) {
        DelayQueue<Mem> delayQueue = new DelayQueue<>();
        //生产者
        new Thread(() -> {
            delayQueue.offer(new Mem("task1", 10000));
            delayQueue.offer(new Mem("task2", 3900));
            Random random = new Random();
            int i = 3;
            //延迟基量
            int delayBase = 500;
            while (true) {
                //延迟偏移量
                int delayOffset = random.nextInt(3000);
                // 延迟在0.5-3.5秒之间
                delayQueue.offer(new Mem("task" + i, delayOffset + delayBase));
                i++;
                try {
                    int sleepSpace = random.nextInt(1000);
                    TimeUnit.MILLISECONDS.sleep(sleepSpace);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //消费者
        new Thread(() -> {
            while (true) {
                try {
                    Delayed take = delayQueue.take();
                    System.out.println(System.currentTimeMillis() + ":" + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}

class Mem implements Delayed {

    private String name;
    private long start = System.currentTimeMillis();
    private long time;

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert((start + time) - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    public Mem(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public long getStart() {
        return start;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Mem{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", time=" + time +
                ", current=" + (time + start) +
                '}';
    }
}

