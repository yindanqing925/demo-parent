package org.nh.xyy.demo.classrelation.equals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author yindanqing
 * @date 2019/5/28 21:58
 * @description
 */
public class Equals {

    public static void main(String[] args) {
        Bean bean1 = new Bean(1, "1");
        Bean bean2 = new Bean(1, "1");
        System.out.println(bean1.equals(bean2));
        HashSet<Bean> set = new HashSet<>();
        set.add(bean1);
        set.add(bean2);
        System.out.println(set.size());
        Map<Bean, String> map = new HashMap<>();
        map.put(bean1, "1");
        map.put(bean2, "2");
        System.out.println(map.get(bean1));
        System.out.println(map.get(bean2));
        System.out.println(map.size());
    }


}
