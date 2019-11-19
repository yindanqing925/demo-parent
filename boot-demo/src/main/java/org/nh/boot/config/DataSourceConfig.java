package org.nh.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
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

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionFactoryRef = DataSourceConfig.SQL_SESSION_FACTORY)
public class DataSourceConfig {

    // 唯一标识
    static final String SIGN = "springboot";
    static final String DATASOURCE = SIGN + "DataSource";
    static final String TRANSACTION_MANAGER = SIGN + "TransactionManager";
    static final String SQL_SESSION_FACTORY = SIGN + "SqlSessionFactory";
    static final String PACKAGE = "org.nh." + SIGN + ".**.dao";
    static final String MAPPER_LOCATION = "classpath*:org/nh/" + SIGN + "/**/*.xml";

    /**
     * # 初始化大小，最小，最大
     * spring.datasource.initialSize=5
     * spring.datasource.minIdle=5
     * spring.datasource.maxActive=20
     * # 配置获取连接等待超时的时间
     * spring.datasource.maxWait=60000
     * # 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
     * spring.datasource.timeBetweenEvictionRunsMillis=60000
     * # 配置一个连接在池中最小生存的时间，单位是毫秒
     * spring.datasource.minEvictableIdleTimeMillis=300000
     * # 校验SQL，Oracle配置 spring.datasource.validationQuery=SELECT 1 FROM DUAL，如果不配validationQuery项，则下面三项配置无用
     * spring.datasource.validationQuery=SELECT 'x'
     * spring.datasource.testWhileIdle=true
     * spring.datasource.testOnBorrow=false
     * spring.datasource.testOnReturn=false
     * # 打开PSCache，并且指定每个连接上PSCache的大小
     * spring.datasource.poolPreparedStatements=true
     * spring.datasource.maxPoolPreparedStatementPerConnectionSize=20
     * # 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
     * spring.datasource.filters=stat,wall,log4j
     * # 通过connectProperties属性来打开mergeSql功能；慢SQL记录
     * spring.datasource.connectionProperties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
     * # 合并多个DruidDataSource的监控数据
     * spring.datasource.useGlobalDataSourceStat=true
     */

    @Primary
    @Bean(name = DATASOURCE)
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://192.168.0.1:3306/logisticsystem?useUnicode=true&characterEncoding=UTF8");
        dataSource.setUsername("u_dev_w");
        dataSource.setPassword("Z8ybNWWVn5JlPsak");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //设置扫描属性
        //设置连接池属性
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(60*1000);
        dataSource.setTimeBetweenEvictionRunsMillis(60*1000);
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        dataSource.setFilters("stat,wall,slf4j");
        Properties properties = new  Properties();
        properties.setProperty("druid.stat.mergeSql","true");
        properties.setProperty("druid.stat.slowSqlMillis","5000");
        dataSource.setConnectProperties(properties);
        dataSource.setUseGlobalDataSourceStat(true);
        return dataSource;
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

    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //servletRegistrationBean.addInitParameter("allow","127.0.0.1");  //设置ip白名单
        //servletRegistrationBean.addInitParameter("deny","192.168.0.19");//设置ip黑名单，优先级高于白名单
        //设置控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter(){
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

}
