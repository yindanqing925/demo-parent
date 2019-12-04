package org.nh.shiro.auth.service;

import org.nh.shiro.auth.domian.AuthUser;

/**
 * @program: AuthPermissionService.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/4 10:45
 */
public interface AuthUserService {

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return
     */
    AuthUser getByUserName(String username);

}
