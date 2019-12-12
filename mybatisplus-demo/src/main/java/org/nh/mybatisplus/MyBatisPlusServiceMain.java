package org.nh.mybatisplus;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: MyBatisPlusServiceMain.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/6 16:20
 */
@SpringBootApplication
@ComponentScan(value = {"org.nh"})
@Log4j2
public class MyBatisPlusServiceMain {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(MyBatisPlusServiceMain.class);
        builder.run(args);
        log.info("MyBatisPlusServiceMain started.");
    }

}
