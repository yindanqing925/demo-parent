package org.nh.gome.demo.interfacedefault;

/**
 * @program: Man.java
 * @description:
 * @author: yindanqing
 * @create: 2020/5/30 11:13
 */
public interface Woman {

    default String talk(){
        return "哭哭";
    }

}
