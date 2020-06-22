package org.nh.mq.consumer.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @program: Mqconfig.java
 * @description: 业务线1mq配置
 * @author: yindanqing
 * @create: 2020/6/20 18:38
 */
@Configuration
public class BusinessOneMqConfig {

    @Bean
    public ConnectionFactory oneConnectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setHost("127.0.0.1");
        cachingConnectionFactory.setUsername("guest");
        cachingConnectionFactory.setPassword("123.gome");
        cachingConnectionFactory.setPort(5672);
        cachingConnectionFactory.setPublisherConfirms(false);
        cachingConnectionFactory.setPublisherReturns(false);
        return cachingConnectionFactory;
    }

    @Bean
    public AmqpAdmin oneAmqpAdmin() {
        return new RabbitAdmin(oneConnectionFactory());
    }

    @Bean
    public RabbitTemplate oneRabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(oneConnectionFactory());
        rabbitTemplate.setMandatory(false);
        rabbitTemplate.setChannelTransacted(false);
        return rabbitTemplate;
    }

}
