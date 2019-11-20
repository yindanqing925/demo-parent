package org.nh.dynamic.config.datasource.way1.routing;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.nh.dynamic.config.datasource.common.DataSourceUtil;
import org.nh.dynamic.config.datasource.master.MasterDataSourceComponent;
import org.nh.dynamic.config.datasource.slave.SlaveDataSourceComponent;
import org.nh.dynamic.config.datasource.way1.pattern.DataSourceType;
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yindanqing
 * @date 2019/11/16 21:49
 * @description 动态数据源
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = DynamicDataSourceConfig.PACKAGE, sqlSessionFactoryRef = DynamicDataSourceConfig.SQL_SESSION_FACTORY)
public class DynamicDataSourceConfig {

    @Autowired
    private MasterDataSourceComponent masterDataSourceComponent;
    @Autowired
    private SlaveDataSourceComponent slaveDataSourceComponent;

    // 唯一标识
    static final String SIGN = "dynamic";
    static final String DATASOURCE = SIGN + "DataSource";
    static final String TRANSACTION_MANAGER = SIGN + "TransactionManager";
    public static final String SQL_SESSION_FACTORY = SIGN + "SqlSessionFactory";
    //可以考虑自定义下面的参数
    public static final String PACKAGE = "org.nh.**.dao";
    static final String MAPPER_LOCATION = "classpath*:org/nh/**/*.xml";

    @Primary
    @Bean(name = DATASOURCE)
    public DynamicDataSourceRouting dynamicDataSourceRouting() throws SQLException {
        DataSource masterDataSource = masterDataSource();
        DataSource slaveDataSource = slaveDataSource();
        Map<Object, Object> targetDataSources = new ConcurrentHashMap<>();
        targetDataSources.put(DataSourceType.MASTER.getMark(), masterDataSource);
        targetDataSources.put(DataSourceType.SLAVE1.getMark(), slaveDataSource);
        return new DynamicDataSourceRouting(masterDataSource, targetDataSources);
    }

    private DataSource masterDataSource() throws SQLException {
        return DataSourceUtil.getInstance().getDataSource(masterDataSourceComponent);
    }

    private DataSource slaveDataSource() throws SQLException {
        return DataSourceUtil.getInstance().getDataSource(slaveDataSourceComponent);
    }

    @Primary
    @Bean(name = TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dynamicDataSourceRouting());
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
