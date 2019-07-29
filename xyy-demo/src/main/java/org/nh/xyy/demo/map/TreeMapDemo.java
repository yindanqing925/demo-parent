package org.nh.xyy.demo.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMapDemo
 *
 * @author yindanqing
 * @description 排序map
 * @date 2019/5/31 14:30
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(23,"23");
        map.put(86,"23");
        map.put(67,"23");
        map.put(56,"23");
        map.put(98,"23");
        for (Iterator<Integer> it = map.keySet().iterator(); it.hasNext(); ){
            Integer next = it.next();
            System.out.println("it" + next + "value:" + map.get(next));
        }
        System.out.println("----------------------");
        TreeMap<Integer, String> treeMap = new TreeMap<>(map);
        for (Iterator<Integer> it = treeMap.keySet().iterator(); it.hasNext(); ){
            Integer next = it.next();
            System.out.println("it" + next + "value:" + map.get(next));
        }
    }

}
