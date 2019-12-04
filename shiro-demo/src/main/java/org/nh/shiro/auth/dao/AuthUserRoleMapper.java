package org.nh.shiro.auth.dao;

import org.nh.shiro.auth.domian.AuthUserRole;

public interface AuthUserRoleMapper {
    int insert(AuthUserRole record);

    int insertSelective(AuthUserRole record);

}