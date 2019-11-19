package org.nh.service.base.user.service;


import org.nh.service.base.user.model.User;

import java.util.Collection;

public interface UserService {

    User getUserInfoById(Integer id);

    int modifyUser(User user);

    /**
     * 1234512312
     */
    int insertBatch(Collection<User> users);

}
