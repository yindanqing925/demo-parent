package org.nh.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: org.nh.mq.consumer.MqConsumerServiceMain.java
 * @description:
 * @author: yindanqing
 * @create: 2020/6/20 18:11
 */
@SpringBootApplication
@ComponentScan(basePackages = { "org.nh" })
public class MqConsumerServiceMain {

    private static final Logger logger = LoggerFactory.getLogger(MqConsumerServiceMain.class);

    public static void main(String[] args) {
        SpringApplicationBuilder application = new SpringApplicationBuilder(MqConsumerServiceMain.class).web(true);
        application.run(args);
        logger.info("mq-consumer service start success.");
    }

}
