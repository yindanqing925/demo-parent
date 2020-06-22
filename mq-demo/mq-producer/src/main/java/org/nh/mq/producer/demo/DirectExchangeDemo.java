package org.nh.mq.producer.demo;

import com.alibaba.fastjson.JSON;
import org.nh.mq.common.constants.MqConstants;
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
public class DirectExchangeDemo {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("127.0.0.1:5672");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("123.gome");
        connectionFactory.setVirtualHost("/");
        /**
         * 设置发送模式, 是否需要确认
         */
        connectionFactory.setPublisherConfirms(false);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //rabbitTemplate.setConfirmCallback(rabbitConfirmCallback);

        /**
         * mandatory
         * 为true时,消息通过交换器无法匹配到队列会返回给生产者
         * 为false时,匹配不到会直接被丢弃
         */
        rabbitTemplate.setMandatory(false);
        //rabbitTemplate.setReturnCallback(rabbitReturnCallback);
        //使用单独的发送连接，避免生产者由于各种原因阻塞而导致消费者同样阻塞
        //rabbitTemplate.setUsePublisherConnection(true);
        System.out.println("消息发送:");
        // rabbitTemplate.setChannelTransacted(false);

        // rabbitTemplate.send("", );
        Object resultLife = rabbitTemplate.convertSendAndReceive(MqConstants.DIRECT_EXCHANGE,
                MqConstants.DIRECT_EXCHANGE_ROUTINGKEY_LIFE, "DIRECT_LIFE");
        System.out.println(JSON.toJSONString(resultLife));
        Object resultWork = rabbitTemplate.convertSendAndReceive(MqConstants.DIRECT_EXCHANGE,
                MqConstants.DIRECT_EXCHANGE_ROUTINGKEY_WORK, "DIRECT_WORK");
        System.out.println(JSON.toJSONString(resultWork));
        connectionFactory.destroy();
    }

}
