package org.nh.service.base.user.service.impl;

import org.nh.service.base.user.dao.UserDao;
import org.nh.service.base.user.model.User;
import org.nh.service.base.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userInfoDao;

    @Override
    public User getUserInfoById(Integer id) {
        User user = userInfoDao.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int modifyUser(User user) {
        return userInfoDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public int insertbatch(Collection<User> users) {
        return userInfoDao.insertbatch(users);
    }
}
