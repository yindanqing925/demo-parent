package org.nh.xyy.demo.future;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import org.nh.xyy.demo.future.indirect.ThirdPartyService;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * BatchDemoDeque
 *
 * @author yindanqing
 * @description ConcurrentHashMap作为队列
 * @date 2019/5/30 11:36
 */
public class BatchDemoMap {

    private static final Map<String, BatchBean> concurrent = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        batchDeal();
        for (; ; ) {
            Thread thread = new Thread(()->{
                try {
                    long orderNo = System.currentTimeMillis();
                    System.out.println("orderNo:" + orderNo);
                    Order order = batchBusiness(String.valueOf(orderNo));
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
            Thread.sleep(300);
        }
    }

    private static Order batchBusiness(String orderNo) throws ExecutionException, InterruptedException {
        BatchBean batchBean = BatchBean.builder()
                .orderNo(orderNo)
                .future(new CompletableFuture<>())
                .build();
        concurrent.put(orderNo, batchBean);
        return batchBean.getFuture().get();
    }

    private static void batchDeal(){
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(()->{
            if(concurrent.isEmpty()){
                return;
            }
            Collection<Order> orders = ThirdPartyService.getOrder(concurrent.keySet());
            orders.forEach(order->{
                concurrent.get(order.getOrderNo()).getFuture().complete(order);
                concurrent.remove(order.getOrderNo());
                System.out.println("Future: orderNo:" + order.getOrderNo() + ", order" + JSON.toJSONString(order) );
            });
        }, 0,2, TimeUnit.SECONDS);
    }

}
