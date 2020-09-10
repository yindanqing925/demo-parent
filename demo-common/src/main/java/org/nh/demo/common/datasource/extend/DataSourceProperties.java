package org.nh.demo.common.datasource.extend;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yindanqing
 * @date 2019/11/16 21:07
 * @description
 */
@Setter
@Getter
public class DataSourceProperties {

    private String url;
    private String driver;
    private String username;
    private String password;
    private int initSize;
    private int minIdle;
    private int maxActive;
    private long maxWait;
    private long timeBetweenEvictionRunsMillis;
    private String validationQuery;
    private boolean testWhileIdle;
    private boolean testOnBorrow;
    private boolean testOnReturn;
    private boolean poolPreparedStatements;
    private int maxPoolPreparedStatementPerConnectionSize;
    private String filters;

}
