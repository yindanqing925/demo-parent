package org.nh.demo.common.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;

import java.nio.charset.Charset;

/**
 * @author yindanqing
 * @date 2019/5/26 23:11
 * @description 自定义tomcat配置基类
 */
public abstract class TomcatConfig {

    protected EmbeddedServletContainerFactory getServletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        if(StringUtils.isNotBlank(getCharSet())){
            factory.setUriEncoding(Charset.forName(getCharSet()));
        }
        if(StringUtils.isNotBlank(getDisplayName())){
            factory.setDisplayName(getDisplayName());
        }
        return factory;
    }

    protected abstract String getCharSet();

    protected abstract String getDisplayName();

}
