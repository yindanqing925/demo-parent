package org.nh.shiro.auth.dao;

import org.nh.shiro.auth.domian.AuthUser;

public interface AuthUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AuthUser record);

    int insertSelective(AuthUser record);

    AuthUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AuthUser record);

    int updateByPrimaryKey(AuthUser record);

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return
     */
    AuthUser selectByUserName(String username);

}