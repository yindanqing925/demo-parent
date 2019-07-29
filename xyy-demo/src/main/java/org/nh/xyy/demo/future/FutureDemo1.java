package org.nh.xyy.demo.future;

import java.util.concurrent.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * FutureDemo1
 *
 * @author yindanqing
 * @description 有返回值的线程
 * @date 2019/5/29 10:42
 */
public class FutureDemo1 {

    private static final int TASK_SIZE = 10;

    private static CountDownLatch count = new CountDownLatch(TASK_SIZE);

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newScheduledThreadPool(1);
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < TASK_SIZE; i++) {
            Callable c = new MyCallable(i + " ");
            count.countDown();
            Future f = pool.submit(c);
            list.add(f);
        }
        count.await();
        pool.shutdown();
        for (Future f : list) {
            System.out.println(">>>" + f.get().toString());
        }
    }
}

class MyCallable implements Callable<String> {
    private String taskNum;

    MyCallable(String taskNum) {
        this.taskNum = taskNum;
    }

    public String call() throws Exception {
        long start = System.currentTimeMillis();
        System.out.println("开始时间"+start);
        Thread.sleep(1000);
        long time = System.currentTimeMillis() - start;
        return taskNum + "线程, 耗时" + time + "毫秒";
    }
}