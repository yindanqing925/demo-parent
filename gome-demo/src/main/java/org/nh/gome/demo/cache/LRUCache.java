package org.nh.gome.demo.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @program: LRUCache.java
 * @description: 使用 ConcurrentHashMap+ConcurrentLinkedQueue+ReadWriteLock+Executors实现线程安全的 LRU 缓存
 * 有点low, 不过我写不出来
 * @author: yindanqing
 * @create: 2020/4/23 15:03
 */
public class LRUCache<K, V> {

    private final int maxCapacity;

    private ConcurrentHashMap<K, V> cahceMap;

    private ConcurrentLinkedQueue<K> keys;


    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock writeLock = readWriteLock.writeLock();

    private Lock readLock = readWriteLock.readLock();

    private ScheduledExecutorService scheduledExecutorService;

    public LRUCache(int maxCapacity) {
        if(maxCapacity < 0){
            throw new IllegalArgumentException("Illegal maxCapacity Argument:" + maxCapacity);
        }
        this.maxCapacity = maxCapacity;
        cahceMap = new ConcurrentHashMap<>(maxCapacity);
        keys = new ConcurrentLinkedQueue<>();
        scheduledExecutorService = Executors.newScheduledThreadPool(3);
    }

    public V put(K k, V v, long expireTime){
        writeLock.lock();
        try{
            if(cahceMap.contains(k)){
                moveToTail(k);
                cahceMap.put(k, v);
                return v;
            }
            if(keys.size() == maxCapacity){
                System.out.println("maxCapacity of cache reached");
                removeOldestElement();
            }
            keys.add(k);
            cahceMap.put(k, v);
            if (expireTime > 0) {
                removeAfterExpireTime(k, expireTime);
            }
            return v;
        }finally {
            writeLock.unlock();
        }
    }

    public V get(K k){
        readLock.lock();
        try {
            if(keys.contains(k)){
                moveToTail(k);
                return cahceMap.get(k);
            }
            return null;
        }finally {
            readLock.unlock();
        }
    }

    public V remove(K k){
        writeLock.lock();
        try{
            if(keys.contains(k)){
                keys.remove(k);
                return cahceMap.remove(k);
            }
            return null;
        }finally {
            writeLock.unlock();
        }
    }

    /**
     * 将元素添加到队列的尾部
     * @param k
     */
    private void moveToTail(K k){
        keys.remove(k);
        keys.add(k);
    }

    /**
     * 移除头部即最少使用的元素
     */
    private void removeOldestElement(){
        K poll = keys.poll();
        if(poll != null){
            cahceMap.remove(poll);
        }
    }

    public int size(){
        return keys.size();
    }

    private void removeAfterExpireTime(K key, long expireTime) {
        scheduledExecutorService.schedule(() -> {
            //过期后清除该键值对
            cahceMap.remove(key);
            keys.remove(key);
        }, expireTime, TimeUnit.MILLISECONDS);
    }

}
