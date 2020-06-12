package org.nh.gome.demo.array;

/**
 * @program: IntegerArray.java
 * @author: yindanqing
 * @create: 2020/6/12 9:39
 * @description: 数组长度不可变
 */
public class IntegerArrayDemo {

    @SuppressWarnings("all")

    public static void main(String[] args) {
        Integer[] array = new Integer[]{0};
        array[1] = 1;
        System.out.println(array.length);
    }

}
