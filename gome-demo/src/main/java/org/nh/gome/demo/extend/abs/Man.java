package org.nh.gome.demo.extend.abs;

/**
 * @program: Man.java
 * @description:
 * @author: yindanqing
 * @create: 2020/5/30 11:20
 */
public class Man extends AbstractMan {

    static {
        System.out.println("child static block");
    }

    public static final String MEMBER = "child static member";

    public void act(){
        System.out.println(AbstractMan.MEMBER);
        System.out.println(Man.MEMBER);
        System.out.println("fuck");
    }

    public Man() {
        super();
    }
}
