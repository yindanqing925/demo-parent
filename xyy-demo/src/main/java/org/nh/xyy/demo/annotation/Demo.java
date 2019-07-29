package org.nh.xyy.demo.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Demo
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/5/29 14:41
 */
public class Demo {

    /**
     * 如果注解被@Inherited修饰
     * 1该注解继承只发生在类继承关系中->(class extends class),接口继承(class implements interface,interface extends interface)的关系中不会发生
     * 2该注解继承不会发生在方法关系的任何地方(重写 or 实现)
     * 3如果子类(class or interface)不重写父类(class or interface)中的方法,子类通过反射获得的方法签名依然是父类的,并且拥有该注解
     * 如果注解不被@Inherited修饰
     * 1该注解继承不会发生在类关系的任何地方(class extends class,interface extends interface,class implements interface)
     * 2同上
     * 3同上
     */
    public static void main(String[] args) {
        //classTest();
        methodTest();
    }

    //class
    public static void classTest(){

        Annotation[] annotations = ClassDemo2.class.getAnnotations();

        Annotation[] annotations1 = InterfaceDemo2.class.getAnnotations();

        Annotation[] annotations2 = InterfaceDemo3.class.getAnnotations();
    }

    //method
    public static void methodTest(){
        Annotation[] annotations = ClassDemo2.class.getMethods()[0].getAnnotations();

        Annotation[] annotations1 = InterfaceDemo2.class.getMethods()[0].getAnnotations();

        Method[] methods = InterfaceDemo3.class.getMethods();
        Annotation[] annotations2 = methods[0].getAnnotations();
    }



}

