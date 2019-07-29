package org.nh.xyy.demo.gc;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Demo
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/5/29 15:55
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        while (true){
            byte[] bytes = new byte[1024*1024];
            list.add(bytes);
        }
    }

    public static void ref(){
        BeanA beanA = new BeanA();
        BeanB beanB = new BeanB();
        beanA.setBeanB(beanB);
        beanB.setBeanA(beanA);
        beanA = null;
        beanB = null;
        System.out.println("sads");
    }

    public static void sout(){
        System.out.println("hello");
    }

}
