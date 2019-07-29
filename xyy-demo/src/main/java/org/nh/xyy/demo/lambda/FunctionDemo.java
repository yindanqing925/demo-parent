package org.nh.xyy.demo.lambda;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * FunctionDemo
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/5/30 14:57
 */
public class FunctionDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> collect = list.stream()
                .map(a -> new FunctionDemo().getResult2(a, b -> b * b))
                .filter(a -> a > 2)
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(list));
        System.out.println(JSON.toJSONString(collect));
    }

    public Integer getResult(int a , Function<Integer, Integer> function){
        return function.apply(a);
    }

    public Integer getResult2(int a , Function<Integer, Integer> function){
        return function.apply(a);
    }

}
