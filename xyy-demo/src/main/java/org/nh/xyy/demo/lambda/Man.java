package org.nh.xyy.demo.lambda;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Man.java
 * @description:
 * @author: yindanqing
 * @create: 2019/11/20 18:08
 */
@Setter
@Getter
public class Man{

    private String name;

    private String age;

    public Man(String age) {
        this.age = age;
    }
    public Man() {
    }
    public static void main(String[] args) {
        Map<String, Man> transactionalCaches = new HashMap();
        transactionalCaches.computeIfAbsent("1", Man::new);
        ManFactory runnable = Man::new;
        ManFactory2 runnable2 = Man::new;
    }
}
interface ManFactory{

    Man getMan(String age);
}

interface ManFactory2{

    Man getMan();
}
