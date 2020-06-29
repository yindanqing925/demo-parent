package org.nh.rq.microservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: RqMicroServiceMain.java
 * @description:
 * @author: yindanqing
 * @create: 2020/6/29 11:34
 */
@SpringBootApplication
@ComponentScan(basePackages = { "org.nh" })
@Slf4j
public class RqMicroServiceMain {

    public static void main(String[] args) {
        SpringApplicationBuilder application = new SpringApplicationBuilder(RqMicroServiceMain.class).web(true);
        application.run(args);
        log.info("rq-microservice start success.");
    }

}
