package org.nh.gome.demo.hashmap;

import java.util.HashMap;

/**
 * @program: HashMapDemo.java
 * @description:
 * @author: yindanqing
 * @create: 2020/5/30 14:16
 */
public class HashMapDemo {

    public static void main(String[] args) {
        /**
         * 当有1024个元素需要加入到hashmap中时
         * 所申请的初始化大小是 1024/0.75 = 1365
         * 在申请长度时, 如果该数字不是2的n次幂, hashmap会自动转为2的n次幂, 即2048
         */
        System.out.println("start");
        HashMap<String, String> hashMap = new HashMap<>(1024);
        hashMap.put("1","1");
        System.out.println(hashMap);
        System.out.println("end");
    }

}
