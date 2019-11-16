package org.nh.dynamic.user.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.nh.dynamic.user.dao.UserDao;
import org.nh.dynamic.user.model.User;
import org.nh.dynamic.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserInfoById(Integer id) {
        User user = userDao.selectByPrimaryKey(id);
        System.out.println(JSON.toJSONString(user));
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = {Exception.class})
    public int updateUpdated(Integer id) {
        User user = User.builder()
                .id(id).updated(new Date(System.currentTimeMillis())).build();
        userDao.updateByPrimaryKeySelective(user);
        throw new RuntimeException("exception");
    }
}
