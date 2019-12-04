package org.nh.shiro.auth.service.impl;

import org.nh.shiro.auth.dao.AuthRoleMapper;
import org.nh.shiro.auth.domian.AuthRole;
import org.nh.shiro.auth.service.AuthRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: AuthRoleServiceImpl.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/4 10:50
 */
@Service
public class AuthRoleServiceImpl implements AuthRoleService {

    @Autowired
    private AuthRoleMapper authRoleMapper;

    @Override
    public List<AuthRole> findByUserId(Long userId) {
        return authRoleMapper.selectByUserId(userId);
    }
}
