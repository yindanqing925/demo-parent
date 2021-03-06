package org.nh.dynamic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yindanqing
 * @date 2019/11/16 19:44
 * @description
 */
@SpringBootApplication
@ComponentScan(value = {"org.nh"})
public class DynamicServiceMain {

    private static final Logger logger = LoggerFactory.getLogger(DynamicServiceMain.class);

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(DynamicServiceMain.class);
        builder.run(args);
        logger.info("DynamicService启动成功.");
    }

}
