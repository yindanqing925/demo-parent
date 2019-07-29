package org.nh.xyy.demo.lambda;

import java.util.function.Predicate;

/**
 * PredicateDemo
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/5/30 16:05
 */
public class PredicateDemo {

    public static void main(String[] args) {
        new PredicateDemo().getResult(a -> a < 0);

    }

    public void getResult(Predicate<Integer> predicate) {
        int i = 7;
        Predicate<Integer> predicate2 = predicate.or(b -> b < 6);
        Predicate<Integer> predicate1 = predicate2.and(b -> b > 4);
        boolean test = predicate1.test(i);
        System.out.println((i<0 || i< 6) && i>4);
        System.out.println(test);

    }

}
