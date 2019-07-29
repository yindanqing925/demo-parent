package org.nh.xyy.demo.inner;

import java.util.ArrayList;
import java.util.List;

/**
 * Worker
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/18 11:21
 */
public class Worker {
    private List<Job> mJobList = new ArrayList<>();

    public static void main(String[] args) {
        new Worker().addJob(()->{
            System.out.println("222");
        });
        Job job = new Worker().new Job(()->{
            System.out.println("222");
        });
        System.out.println("11");
    }

    public void addJob(Runnable task) {
        mJobList.add(new Job(task));
    }

    private class Job implements Runnable {
        Runnable task;
        public  Job(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            task.run();
            System.out.println("left job size : " + mJobList.size());
        }
    }
}
