package org.nh.mybatisplus.config.datasource;

import lombok.Getter;
import lombok.Setter;
import org.nh.demo.common.datasource.extend.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @program: MybatisPlusDataSourceComponent.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/3 19:16
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "mybatisplus.datasource.master")
@Component(value = "mybatisPlusDataSourceComponent")
public class MybatisPlusDataSourceComponent extends DataSourceProperties {
}
