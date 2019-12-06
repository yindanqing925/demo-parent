package org.nh.mybatisplus.config.datasource;

import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
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

/**
 * @program: ShiroDataSourceConfig.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/3 17:10
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = MybatisPlusDataSourceConfig.PACKAGE, sqlSessionFactoryRef = MybatisPlusDataSourceConfig.SQL_SESSION_FACTORY)
public class MybatisPlusDataSourceConfig {

    // 唯一标识
    static final String SIGN = "mybatisplus";
    static final String DATASOURCE = SIGN + "DataSource";
    static final String TRANSACTION_MANAGER = SIGN + "TransactionManager";
    static final String SQL_SESSION_FACTORY = SIGN + "SqlSessionFactory";
    static final String PACKAGE = "org.nh." + SIGN + ".**.mapper";
    static final String MAPPER_LOCATION = "classpath*:org/nh/" + SIGN + "/**/*.xml";
    static final String TYPE_ALIASES_PACKAGE = "classpath*:org/nh/" + SIGN + "/**/*.xml";

    @Autowired
    private MybatisPlusDataSourceComponent mybatisPlusDataSourceComponent;

    @Primary
    @Bean(name = DATASOURCE)
    public DataSource dataSource() throws SQLException {
        return DataSourceUtil.getInstance().getDataSource(mybatisPlusDataSourceComponent);
    }

    @Primary
    @Bean(name = TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * 特别注意, mybatis-plus要求自己的sqlSessionFactory, 不然会出现问题
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Primary
    @Bean(name = SQL_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactory(@Qualifier(DATASOURCE) DataSource dataSource) throws Exception {
        final MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        sqlSessionFactory.setTypeAliasesPackage(PACKAGE);
        return sqlSessionFactory.getObject();
    }

}
