package org.nh.xyy.demo.future.indirect;

import org.nh.xyy.demo.future.Order;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ThirdPartyService
 *
 * @author yindanqing
 * @description TODO
 * @date 2019/5/30 11:52
 */
public class ThirdPartyService {


    public static String getOrder(String orderNo){
        System.out.println(orderNo);
        return orderNo;
    }

    public static Collection<Order> getOrder(Collection<String> orderNos){
        return orderNos.stream().map(Order::new).collect(Collectors.toList());
    }
}
