package org.nh.shiro.auth.service;

import org.nh.shiro.auth.domian.AuthRole;

import java.util.List;

/**
 * @program: AuthPermissionService.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/4 10:45
 */
public interface AuthRoleService {

    /**
     * 根据用户ID查询用户的角色列表
     * @param userId
     * @return
     */
    List<AuthRole> findByUserId(Long userId);

}
