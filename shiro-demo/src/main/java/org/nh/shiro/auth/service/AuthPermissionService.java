package org.nh.shiro.auth.service;

import org.nh.shiro.auth.domian.AuthPermission;

import java.util.List;

/**
 * @program: AuthPermissionService.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/4 10:45
 */
public interface AuthPermissionService {

    /**
     * 根据roleId集合查询对应权限列表
     * @param roleIdList
     * @return
     */
    List<AuthPermission> findByRoleList(List<Long> roleIdList);

}
