package org.nh.mq.consumer.queues;

import lombok.extern.slf4j.Slf4j;
import org.nh.mq.common.constants.MqConstants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: GdzQueueConsumer.java
 * @description:
 * @author: yindanqing
 * @create: 2020/6/20 18:26
 */
@Component
@Slf4j
public class DirectQueueConsumer {

    private static final String FEEDBACK = "success";

    @RabbitListener(queues = MqConstants.DIRECT_QUEUE_LIFE)
    @RabbitHandler
    public String consumeLifeMessage(String message) {
        log.info("DirectQueueConsumer life queue received : " + message);
        return FEEDBACK;
    }

    @RabbitListener(queues = MqConstants.DIRECT_QUEUE_WORK)
    @RabbitHandler
    public String consumeWorkMessage(String message) {
        log.info("DirectQueueConsumer work queue received : " + message);
        return FEEDBACK;
    }

}
