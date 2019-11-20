package org.nh.dynamic.user.service;

import org.nh.service.base.user.model.User;

public interface UserDynamicService {

    User getUserInfoById(Integer id);

    /**
     * 更新(更新时间)字段
     * @param id
     * @return
     */
    int updateUpdated(Integer id);

}
