package org.nh.xyy.demo.reflect;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Box
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/3 15:49
 */
public class Box{

    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception  {
        new Box().forName();
    }

    public void forName() throws Exception {
        Class clazz = int.class;
        Class clazzI = Class.forName("java.lang.Integer");
        System.out.println(addressOf(clazz));
        System.out.println(addressOf(clazzI));
    }

    public void boxType() throws Exception {
        Class clazz1 = new Integer(150).getClass();
        Class clazz2 = int.class;
        Class clazz3 = new Integer(1).getClass();
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
    }

    public static long addressOf(Object o) throws Exception {

        Object[] array = new Object[] { o };

        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long objectAddress;
        switch (addressSize) {
            case 4:
                objectAddress = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new Error("unsupported address size: " + addressSize);
        }
        return (objectAddress);
    }

    public void methodSing()  throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Box box = new Box();
        Class clazz = box.getClass();
        Method method = clazz.getDeclaredMethod("getString", Integer.class);
        method.setAccessible(true);
        method.invoke(box, new Integer(1));
        Method method2 = clazz.getDeclaredMethod("getString", int.class);
        method2.setAccessible(true);
        method2.invoke(box, 1);
    }

    public void getString(Integer i){
        System.out.println("Integer");
    }

    public void getString(int i){
        System.out.println("int");
    }

}
