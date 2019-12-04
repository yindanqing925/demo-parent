package org.nh.shiro.auth.dao;

import org.apache.ibatis.annotations.Param;
import org.nh.shiro.auth.domian.AuthPermission;

import java.util.List;

public interface AuthPermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthPermission record);

    int insertSelective(AuthPermission record);

    AuthPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthPermission record);

    int updateByPrimaryKey(AuthPermission record);

    /**
     * 根据roleId集合查询对应权限列表
     * @param roleIdList
     * @return
     */
    List<AuthPermission> selectByRoleList(@Param(value = "roleIdList") List<Long> roleIdList);

}