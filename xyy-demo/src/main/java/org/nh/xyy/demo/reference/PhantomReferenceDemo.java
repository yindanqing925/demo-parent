package org.nh.xyy.demo.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * PhantomReferenceDemo
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/18 9:32
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference phantomReference =
                new PhantomReference<>(new String("12344412"), referenceQueue);
        System.out.println("12 " + phantomReference.get());
        System.gc();
        Reference<String> reference;
        while ((reference = referenceQueue.poll()) != null){
            if (reference == phantomReference){
                System.out.println("gc success");
            }
        }
        Thread.sleep(2*1000);
    }

}
