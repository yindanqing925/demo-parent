package org.nh.mq.producer;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class MqProducerServiceMain {

    public static void main(String[] args) {
        SpringApplicationBuilder application = new SpringApplicationBuilder(MqProducerServiceMain.class).web(true);
        application.run(args);
        log.info("mq-producer service start success.");
    }

}
