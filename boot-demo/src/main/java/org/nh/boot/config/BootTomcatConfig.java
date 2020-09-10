package org.nh.boot.config;

import org.nh.demo.common.config.TomcatConfig;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yindanqing
 * @date 2019/5/26 23:22
 * @description 自定义tomcat配置
 */
@Configuration
public class BootTomcatConfig extends TomcatConfig {

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        return super.getServletContainer();
    }

    @Override
    protected String getCharSet() {
        return "UTF-8";
    }

    @Override
    protected String getDisplayName() {
        return null;
    }

}
