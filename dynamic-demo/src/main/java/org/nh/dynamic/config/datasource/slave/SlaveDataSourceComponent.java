package org.nh.dynamic.config.datasource.slave;

import lombok.Getter;
import lombok.Setter;
import org.nh.common.datasource.extend.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yindanqing
 * @date 2019/11/17 0:03
 * @description
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "dynamic.datasource.slave1")
@Component(value = "slaveDataSourceComponent")
public class SlaveDataSourceComponent extends DataSourceProperties {

}
