package org.nh.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @program: AsyncServiceMain.java
 * @description:
 * @author: yindanqing
 * @create: 2019/11/20 19:17
 */
@Slf4j
@SpringBootApplication
@EnableAsync
public class AsyncServiceMain {

    public static void main(String[] args) {
        SpringApplicationBuilder applicationBuilder = new SpringApplicationBuilder(AsyncServiceMain.class);
        applicationBuilder.run(args);
        log.info("AsyncService start up.");
    }

}
