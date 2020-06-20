package org.nh.mq.producer.demo;

import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @program: Demo.java
 * @description:
 * @author: yindanqing
 * @create: 2020/6/20 19:30
 */
public class Demo {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("127.0.0.1:5672");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("123.gome");
        connectionFactory.setVirtualHost("/");
        // 如果需要confirm则设置为true
        connectionFactory.setPublisherConfirms(true);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //rabbitTemplate.setConfirmCallback(rabbitConfirmCallback);

        rabbitTemplate.setMandatory(true);
        //rabbitTemplate.setReturnCallback(rabbitReturnCallback);
        //使用单独的发送连接，避免生产者由于各种原因阻塞而导致消费者同样阻塞
        //rabbitTemplate.setUsePublisherConnection(true);
        System.out.println("消息发送:");
        // rabbitTemplate.setChannelTransacted(false);

        // rabbitTemplate.setChannelTransacted(true);
        // rabbitTemplate.send("", );
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        while (true){
            rabbitTemplate.convertAndSend(
                    "GUDUZHOU_EXCHANGE",
                    null, "我草泥马", msg -> {
                        MessageProperties properties = msg.getMessageProperties();
                        properties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                        Map<String, Object> headers = msg.getMessageProperties().getHeaders();
                        headers.putAll(map);
                        return msg;
                    }, new CorrelationData(UUID.randomUUID().toString())
            );
            Thread.sleep(2*1000);
        }


    }

}
