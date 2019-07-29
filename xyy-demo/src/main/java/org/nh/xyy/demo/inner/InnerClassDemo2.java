package org.nh.xyy.demo.inner;

/**
 * InnerClassDemo2
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/18 11:30
 */
public class InnerClassDemo2 {

    public static void main(String[] args) {
        System.out.println("123123");
    }

    public void run() {
        int age = 10;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int myAge = age + 1;
                System.out.println(myAge);
            }
        };
    }

/*    public void run2() {
        int age = 10;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int myAge = age + 1;
                System.out.println(myAge);
                age = 20;
            }
        };
    }*/
}
