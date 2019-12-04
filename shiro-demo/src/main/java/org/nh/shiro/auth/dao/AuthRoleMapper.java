package org.nh.shiro.auth.dao;

import org.apache.ibatis.annotations.Param;
import org.nh.shiro.auth.domian.AuthRole;

import java.util.List;

public interface AuthRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthRole record);

    int insertSelective(AuthRole record);

    AuthRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthRole record);

    int updateByPrimaryKey(AuthRole record);

    /**
     * 根据用户ID查询用户的角色列表
     * @param userId
     * @return
     */
    List<AuthRole> selectByUserId(@Param(value = "userId") Long userId);

}