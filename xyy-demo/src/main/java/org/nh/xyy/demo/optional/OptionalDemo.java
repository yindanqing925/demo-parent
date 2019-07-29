package org.nh.xyy.demo.optional;

import java.util.Optional;

/**
 * OptionalDemo
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/6/10 15:59
 */
public class OptionalDemo {

    public static void main(String[] args) {
        Optional<String> fengCheng = Optional.<String>ofNullable("FengCheng");
        Optional<Integer> deposit = Optional.<Integer>ofNullable(10000_0000);
        System.out.println(new OptionalDemo().getString(fengCheng, deposit));
    }

    public String getString(Optional<String> user, Optional<Integer> money){
        assert user.isPresent();
        assert user.get().equals("");
        user.ifPresent(System.out::println);
        Integer orElse = money.orElse(0);
        return "用户 : " + user.get() + ", 存款 : " + orElse;
    }

}
