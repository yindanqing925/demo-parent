package org.nh.shiro.auth.service.impl;

import org.nh.shiro.auth.dao.AuthPermissionMapper;
import org.nh.shiro.auth.domian.AuthPermission;
import org.nh.shiro.auth.service.AuthPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: AuthPermissionServiceImpl.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/4 10:49
 */
@Service
public class AuthPermissionServiceImpl implements AuthPermissionService {

    @Autowired
    private AuthPermissionMapper authPermissionMapper;

    @Override
    public List<AuthPermission> findByRoleList(List<Long> roleIdList) {
        return authPermissionMapper.selectByRoleList(roleIdList);
    }
}
