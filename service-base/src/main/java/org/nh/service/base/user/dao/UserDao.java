package org.nh.service.base.user.dao;

import org.apache.ibatis.annotations.Param;
import org.nh.service.base.user.model.User;

import java.util.Collection;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int insertbatch(@Param(value = "users") Collection<User> users);
}