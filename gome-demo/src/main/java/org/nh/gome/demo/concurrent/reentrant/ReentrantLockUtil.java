package org.nh.gome.demo.concurrent.reentrant;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: ReentrantLockUtil.java
 * @description:
 * @author: yindanqing
 * @create: 2019/11/14 14:30
 */
public class ReentrantLockUtil {

    private final Map<String, Integer> m = new TreeMap<>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public Integer get(String key) {
        r.lock();
        try {
            return m.get(key);
        } finally {
            r.unlock();
        }
    }

    public String[] allKeys() {
        r.lock();
        try {
            return (String[])m.keySet().toArray();
        } finally {
            r.unlock();
        }
    }

    public Integer put(String key, Integer value) {
        w.lock();
        try {
            return m.put(key, value);
        } finally {
            w.unlock();
        }
    }

    public void clear() {
        w.lock();
        try {
            m.clear();
        } finally {
            w.unlock();
        }
    }

}
