package org.nh.shiro.auth.dao;

import org.nh.shiro.auth.domian.AuthRolePermission;

public interface AuthRolePermissionMapper {
    int insert(AuthRolePermission record);

    int insertSelective(AuthRolePermission record);
}