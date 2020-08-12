package org.nh.gome.demo.build;

/**
 * @program: Man.java
 * @description:
 * @author: yindanqing
 * @create: 2020/8/11 14:25
 */
public class Demo {

    public static void main(String[] args) {
        new Man('A');
    }

}

class Man{
    private int age;

    public Man() {
    }

    public Man(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
