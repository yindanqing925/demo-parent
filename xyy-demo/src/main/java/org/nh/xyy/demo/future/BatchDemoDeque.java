package org.nh.xyy.demo.future;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;
import org.nh.xyy.demo.future.indirect.ThirdPartyService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * BatchDemoDeque
 *
 * @author yindanqing
 * @description LinkedBlockingDeque作为队列, 有缺陷, 个人认为map的更好一点
 * @date 2019/5/30 11:36
 */
public class BatchDemoDeque {

    private static final LinkedBlockingDeque<BatchBean> QUEUE = new LinkedBlockingDeque<>();

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
        QUEUE.push(batchBean);
        return batchBean.getFuture().get();
    }

    private static void batchDeal(){
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(()->{
            if(CollectionUtils.isEmpty(QUEUE)){
                return;
            }
            Map<String, BatchBean> batchBeanMap = QUEUE.stream().collect(Collectors.toMap(BatchBean::getOrderNo, a -> a, (a, b) -> b));
            QUEUE.clear();
            Collection<Order> orders = ThirdPartyService.getOrder(batchBeanMap.keySet());
            orders.forEach(order->{
                batchBeanMap.get(order.getOrderNo()).getFuture().complete(order);
                System.out.println("Future: orderNo:" + order.getOrderNo() + ", order" + JSON.toJSONString(order) );
            });
        }, 0,2, TimeUnit.SECONDS);
    }

}

@Setter
@Getter
@Builder
class BatchBean {

    private String orderNo;

    private CompletableFuture<Order> future;

}