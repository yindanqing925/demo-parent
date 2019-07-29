package org.nh.xyy.demo.reference;

import java.lang.ref.WeakReference;

/**
 * 弱引用Demo
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        WeakReference<String> weakReference = new WeakReference<>(new String("123"));
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());
    }

}

