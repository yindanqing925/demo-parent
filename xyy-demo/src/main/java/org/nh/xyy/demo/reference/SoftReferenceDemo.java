package org.nh.xyy.demo.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用Demo
 */
public class SoftReferenceDemo {

    public static void main(String[] args) {
        int count = 5;
        SoftReference[] softReferences = new SoftReference[count];

        for (int i = 0; i < 5 ; i++) {
            softReferences[i] = new SoftReference<TestObject>(new TestObject("11"));
        }
        for (int i = 0; i < 5 ; i++) {
            Object o = softReferences[i].get();
            if(o == null){
                System.out.println("null");
                continue;
            }
            System.out.println(((TestObject) o).name);
        }
    }

}
class TestObject{
    public byte[] values;
    public String name;

    public TestObject(String name) {
        this.values = new byte[1024 * 1024 * 1000];
        this.name = name;
    }
}