package org.nh.mq.producer.demo;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.nh.mq.common.constants.MqConstants;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

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
public class HeadersExchangeDemo {
    private static MessagePostProcessor HEADERS_LIFE;
    private static MessagePostProcessor HEADERS_WORK;
    static {
        HEADERS_LIFE = message -> {
            message.getMessageProperties().setHeader("QUEUE_ROUTE", "HEADERS_LIFE");
            return message;
        };
        HEADERS_WORK = message -> {
            message.getMessageProperties().setHeader("QUEUE_ROUTE", "HEADERS_WORK");
            return message;
        };
    }

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
        rabbitTemplate.setChannelTransacted(false);
        //rabbitTemplate.send("", );
        /**
         *
         */
        Object resultLife = rabbitTemplate.convertSendAndReceive(MqConstants.HEADERS_EXCHANGE,
                MqConstants.HEADERS_EXCHANGE_ROUTINGKEY_LIFE, "HEADERS_LIFE", HEADERS_LIFE);
        System.out.println(JSON.toJSONString(resultLife));
        Object resultWork = rabbitTemplate.convertSendAndReceive(MqConstants.HEADERS_EXCHANGE,
                MqConstants.HEADERS_EXCHANGE_ROUTINGKEY_WORK, "HEADERS_WORK", HEADERS_WORK);
        System.out.println(JSON.toJSONString(resultWork));
        connectionFactory.destroy();

    }

}
