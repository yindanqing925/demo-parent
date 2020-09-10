package org.nh.demo.common.datasource.common;

import com.alibaba.druid.pool.DruidDataSource;
import org.nh.demo.common.datasource.extend.DataSourceProperties;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author yindanqing
 * @date 2019/11/16 21:05
 * @description 根据配置对象父类, 获取对象数据源
 */
public class DataSourceUtil {

    private static DataSourceUtil dataSourceUtil = null;

    public static DataSourceUtil getInstance(){
        if (dataSourceUtil == null){
            synchronized (DataSourceUtil.class){
                if(dataSourceUtil == null){
                    dataSourceUtil = new DataSourceUtil();
                }
            }
        }
        return dataSourceUtil;
    }

    public DataSource getDataSource(DataSourceProperties component) throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(component.getUrl());
        dataSource.setUsername(component.getUsername());
        dataSource.setPassword(component.getPassword());
        dataSource.setDriverClassName(component.getDriver());
        //设置扫描属性
        //设置连接池属性
        dataSource.setInitialSize(component.getInitSize());
        dataSource.setMinIdle(component.getMinIdle());
        dataSource.setMaxActive(component.getMaxActive());
        dataSource.setMaxWait(component.getMaxWait());
        dataSource.setTimeBetweenEvictionRunsMillis(component.getTimeBetweenEvictionRunsMillis());
        dataSource.setValidationQuery(component.getValidationQuery());
        dataSource.setTestWhileIdle(component.isTestWhileIdle());
        dataSource.setTestOnBorrow(component.isTestOnBorrow());
        dataSource.setTestOnReturn(component.isTestOnReturn());
        dataSource.setPoolPreparedStatements(component.isPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(component.getMaxPoolPreparedStatementPerConnectionSize());
        dataSource.setFilters(component.getFilters());
        Properties properties = new  Properties();
        properties.setProperty("druid.stat.mergeSql","true");
        properties.setProperty("druid.stat.slowSqlMillis","5000");
        dataSource.setConnectProperties(properties);
        dataSource.setUseGlobalDataSourceStat(true);
        return dataSource;
    }

    private DataSourceUtil() {
    }

}
