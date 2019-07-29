package org.nh.xyy.demo.annotation;

import java.lang.annotation.Documented;

/**
 * ClassDemo
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/5/29 14:42
 */
@Annotation
public class ClassDemo {

    @Annotation
    public void getString(){
        System.out.println("11");
    }

}
