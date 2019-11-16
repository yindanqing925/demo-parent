package org.nh.dynamic.config.datasource.way1.annotation;

import org.nh.dynamic.config.datasource.way1.pattern.DataSourceMode;
import org.nh.dynamic.config.datasource.way1.pattern.DataSourceType;

import java.lang.annotation.*;

/**
 * @author yindanqing
 * @date 2019/11/16 22:03
 * @description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    /**
     * 数据源选择模式, 默认轮询模式, 显示设置此值, 则可以更正对应模式
     * @return
     */
    DataSourceMode mode() default DataSourceMode.POLL;

    /**
     * 数据源类型, 当模式为指定类型时, 该值才会生效,
     * 选择数据源时会选择该值指定数据源
     * @return
     */
    DataSourceType type() default DataSourceType.MASTER ;
}
