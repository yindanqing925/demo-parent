package org.nh.gome.demo.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @program: Profiler.java
 * @description: 并发编程中摘抄的threadlocal示例
 * @author: yindanqing
 * @create: 2020/12/15 17:15
 */
public class Profiler {

    // 第一次get()方法调用时会进行初始化（如果set方法没有调用），每个线程会调用一次
    private static final ThreadLocal<Long> TIME_THREADLOCAL = ThreadLocal.withInitial(System::currentTimeMillis);

    public static final void begin() {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end() {
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws Exception {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }

}
