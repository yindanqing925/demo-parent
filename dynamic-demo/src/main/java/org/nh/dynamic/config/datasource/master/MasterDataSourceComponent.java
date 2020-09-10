package org.nh.dynamic.config.datasource.master;

import lombok.Getter;
import lombok.Setter;
import org.nh.demo.common.datasource.extend.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yindanqing
 * @date 2019/11/17 0:03
 * @description
 */

@Setter
@Getter
@ConfigurationProperties(prefix = "dynamic.datasource.master")
@Component(value = "masterDataSourceComponent")
public class MasterDataSourceComponent extends DataSourceProperties {

}