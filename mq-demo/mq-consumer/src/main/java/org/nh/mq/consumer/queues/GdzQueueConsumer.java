package org.nh.mq.consumer.queues;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @program: GdzQueueConsumer.java
 * @description:
 * @author: yindanqing
 * @create: 2020/6/20 18:26
 */
@Component
public class GdzQueueConsumer {

    @RabbitListener(queues = "GUDUZHOU_QUEUEN")
    @RabbitHandler
    public void process(String message) {
        System.out.println("Receiver : " + message);
    }
}
