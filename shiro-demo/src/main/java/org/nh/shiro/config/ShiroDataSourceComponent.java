package org.nh.shiro.config;

import lombok.Getter;
import lombok.Setter;
import org.nh.demo.common.datasource.extend.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: ShiroDataSourceComponent.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/3 19:16
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "shiro.datasource.master")
@Component(value = "shiroDataSourceComponent")
public class ShiroDataSourceComponent extends DataSourceProperties {
}
