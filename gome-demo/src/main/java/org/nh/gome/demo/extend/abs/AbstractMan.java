package org.nh.gome.demo.extend.abs;

/**
 * @program: AbstractMan.java
 * @description:
 * @author: yindanqing
 * @create: 2020/5/30 11:19
 */
public abstract class AbstractMan {

    static {
        System.out.println("super static block");
    }

    public static final String MEMBER = "super static member";

    public void say(){
        System.out.println("man");
    }

    public AbstractMan() {
        super();
    }
}
