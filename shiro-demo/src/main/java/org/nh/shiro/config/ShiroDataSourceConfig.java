package org.nh.shiro.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.nh.common.datasource.common.DataSourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @program: ShiroDataSourceConfig.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/3 17:10
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = ShiroDataSourceConfig.PACKAGE, sqlSessionFactoryRef = ShiroDataSourceConfig.SQL_SESSION_FACTORY)
public class ShiroDataSourceConfig {

    // 唯一标识
    static final String SIGN = "shiro";
    static final String DATASOURCE = SIGN + "DataSource";
    static final String TRANSACTION_MANAGER = SIGN + "TransactionManager";
    static final String SQL_SESSION_FACTORY = SIGN + "SqlSessionFactory";
    static final String PACKAGE = "org.nh.**.dao";
    static final String MAPPER_LOCATION = "classpath*:org/nh/" + SIGN + "/**/*.xml";

    @Autowired
    private ShiroDataSourceComponent shiroDataSourceComponent;

    @Primary
    @Bean(name = DATASOURCE)
    public DataSource dataSource() throws SQLException {
        return DataSourceUtil.getInstance().getDataSource(shiroDataSourceComponent);
    }

    @Primary
    @Bean(name = TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }

    @Primary
    @Bean(name = SQL_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactory(@Qualifier(DATASOURCE) DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sessionFactory.getObject();
    }


}
