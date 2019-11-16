package org.nh.dynamic.user.service;

import org.nh.dynamic.user.model.User;

public interface UserService {

    User getUserInfoById(Integer id);

    /**
     * 更新(更新时间)字段
     * @param id
     * @return
     */
    int updateUpdated(Integer id);

}
