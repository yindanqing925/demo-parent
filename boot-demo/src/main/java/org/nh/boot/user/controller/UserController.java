package org.nh.boot.user.controller;

import org.nh.demo.common.web.ResponseResult;
import org.nh.service.base.user.model.User;
import org.nh.service.base.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: UserController.java
 * @description:
 * @author: yindanqing
 * @create: 2019/11/20 16:42
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    public ResponseResult<User> getUserById(@PathVariable(value = "id") Integer id){
        ResponseResult<User> result = new ResponseResult<>();
        result.setData(userService.getUserInfoById(id));
        return result;
    }

}
