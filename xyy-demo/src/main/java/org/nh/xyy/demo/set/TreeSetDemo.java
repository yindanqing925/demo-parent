package org.nh.xyy.demo.set;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSetDemo
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/5/31 14:24
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(18);
        set.add(87);
        set.add(32);
        set.add(44);
        set.add(52);
        set.add(36);
        set.forEach(System.out::println);
        System.out.println("-------------");
        TreeSet<Integer> treeSet = new TreeSet<>(set);
        treeSet.forEach(System.out::println);
    }

}
