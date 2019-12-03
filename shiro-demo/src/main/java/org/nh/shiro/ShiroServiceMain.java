package org.nh.shiro;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: ShiroServiceMain.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/3 16:56
 */
@SpringBootApplication
@ComponentScan(value = {"org.nh"})
@Log4j2
public class ShiroServiceMain {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ShiroServiceMain.class);
        builder.run(args);
        log.info("ShiroServiceMain 启动成功");
    }

}
