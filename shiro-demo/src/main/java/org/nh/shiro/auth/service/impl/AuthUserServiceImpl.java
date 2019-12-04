package org.nh.shiro.auth.service.impl;

import org.nh.shiro.auth.dao.AuthUserMapper;
import org.nh.shiro.auth.domian.AuthUser;
import org.nh.shiro.auth.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: AuthUserServiceImpl.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/4 10:51
 */
@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserMapper authUserMapper;

    @Override
    public AuthUser getByUserName(String username) {
        return authUserMapper.selectByUserName(username);
    }
}
