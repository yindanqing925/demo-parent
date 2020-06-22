package org.nh.mq.consumer.queues;

import lombok.extern.slf4j.Slf4j;
import org.nh.mq.common.constants.MqConstants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @program: FANOUTQueueConsumer.java
 * @description:
 * @author: yindanqing
 * @create: 2020/6/22 14:19
 */
@Component
@Slf4j
public class HeadersQueueConsumer {

    @RabbitListener(queues = MqConstants.HEADERS_QUEUE_LIFE)
    @RabbitHandler
    public String consumeLifeMessage(String message) {
        log.info("HeadersQueueConsumer life queue received : " + message);
        return MqConstants.HEADERS_QUEUE_LIFE + File.separator + MqConstants.FEEDBACK;
    }

    @RabbitListener(queues = MqConstants.HEADERS_QUEUE_WORK)
    @RabbitHandler
    public String consumeWorkMessage(String message) {
        log.info("HeadersQueueConsumer work queue received : " + message);
        return MqConstants.HEADERS_QUEUE_WORK + File.separator + MqConstants.FEEDBACK;
    }

}
