package org.nh.dynamic.config.datasource.way1.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.nh.dynamic.config.datasource.way1.annotation.DataSource;
import org.nh.dynamic.config.datasource.way1.holder.DynamicDataSourceContextHolder;
import org.nh.dynamic.config.datasource.way1.pattern.DataSourceMode;
import org.nh.dynamic.config.datasource.way1.pattern.DataSourceType;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author yindanqing
 * @date 2019/11/16 22:18
 * @description
 */
@Aspect
@Order(1)
@Component
@Slf4j
public class DataSourceAspect {

    /**
     * 数据源选择模式
     */
    private static final int POLL_MODE = DataSourceMode.POLL.getMark();
    private static final int ASSIGN_MODE = DataSourceMode.ASSIGN.getMark();

    /**
     * 维护一个所有数据源的集合
     * 拒绝动态扩展, 不过好像这里支持也是不行的
     */
    private static final List<Integer> DATASOURCE_TYPE_LIST =
            Arrays.stream(DataSourceType.values()).map(DataSourceType::getMark).collect(Collectors.toList());

    private static final Integer MOLD = DATASOURCE_TYPE_LIST.size();

    //请求计数
    private static volatile AtomicInteger count = new AtomicInteger(0);

    /**
     * 声明注解切点
     */
    @Pointcut("@annotation(org.nh.dynamic.config.datasource.way1.annotation.DataSource)")
    private void dataSourceAspect(){
    }

    @Around("dataSourceAspect()")
    public Object dataSourceAspectAround(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        DataSource dataSource = method.getAnnotation(DataSource.class);
        if(POLL_MODE == dataSource.mode().getMark()){
            int current = count.getAndIncrement();
            log.info("当前请求计数值为:{}", current);
            Integer target = DATASOURCE_TYPE_LIST.get(current % MOLD);
            DynamicDataSourceContextHolder.setDataSourceType(target);
        } else if(ASSIGN_MODE == dataSource.mode().getMark()){
            DynamicDataSourceContextHolder.setDataSourceType(dataSource.type().getMark());
        }
        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
    }

}
