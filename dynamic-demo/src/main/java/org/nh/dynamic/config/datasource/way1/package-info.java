/**
 * @author yindanqing
 * @date 2019/11/16 21:54
 * @description 第一种方法
 *
 * 将两个或多个数据源在外面包一层, 成为一个多数据源的数据源, 本身, 他还是一个数据源,
 * 在选择数据源的时候去切, 这种是不需要注入多余数据源的, 就是内层的master和slave数据是不注入的
 * 我们在这里只需要一个主的dynamicDataSource即可
 *
 * 用的是一个sqlSessionFactory, 因为在spring看来, 这是一个数据源
 * transactionManager是生效的, 应该也是一个
 */
package org.nh.dynamic.config.datasource.way1;