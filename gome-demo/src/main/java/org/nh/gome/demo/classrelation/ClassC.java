package org.nh.gome.demo.classrelation;

/**
 *
 * 类加载的执行关系
 *
 * 父类静态代变量
 * 父类静态代码块
 * 子类静态变量
 * 子类静态代码块
 * 父类非静态变量（父类实例成员变量）
 * 父类构造函数
 * 子类非静态变量（子类实例成员变量）
 * 子类构造函数
 *
 * 一个特别有趣的现象是，成员变量的声明和赋值要晚于静态而早于构造函数开始，而且一旦开始构造函数，成员变量已经完成了声明和赋值，
 * 但是，如果父类中调用到了子类中的成员变量，那么这个时候（子类的构造函数还未开始），子类中的成员变量会是一个仅声明且赋默认值的变量，
 * 直到子类构造函数开始之前，才会完成子类成员变量的赋值工作
 *
 */
public class ClassC {

    public static void main(String[] args) {
        new ClassB(20);
    }

}

abstract class ClassA{

    protected int c = 100;
    protected static int d = 30;

    public ClassA() {
        print();
    }

    abstract void print();

}

class ClassB extends ClassA{

    private int a = 100;
    private static int b = 30;

    public ClassB(int a) {
        System.out.println(this.a);
        System.out.println(this.b);
        this.a = a;
    }

    @Override
    void print() {
        System.out.println(a);
    }
}
