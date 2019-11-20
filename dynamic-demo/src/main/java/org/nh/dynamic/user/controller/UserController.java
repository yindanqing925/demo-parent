package org.nh.dynamic.user.controller;

import org.nh.common.web.ResponseResult;
import org.nh.dynamic.config.datasource.way1.annotation.DataSource;
import org.nh.dynamic.config.datasource.way1.pattern.DataSourceMode;
import org.nh.dynamic.config.datasource.way1.pattern.DataSourceType;
import org.nh.dynamic.user.service.UserDynamicService;
import org.nh.service.base.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserDynamicService userService;

    @RequestMapping(value = "/getUserById/poll/{id}", method = RequestMethod.GET)
    @DataSource
    public ResponseResult<User> getUserByIdPoll(@PathVariable(value = "id") Integer id){
        ResponseResult<User> result = new ResponseResult<>();
        result.setData(userService.getUserInfoById(id));
        return result;
    }

    @RequestMapping(value = "/getUserById/master/{id}", method = RequestMethod.GET)
    @DataSource(mode = DataSourceMode.ASSIGN, type = DataSourceType.MASTER)
    public ResponseResult<User> getUserByIdMaster(@PathVariable(value = "id") Integer id){
        ResponseResult<User> result = new ResponseResult<>();
        result.setData(userService.getUserInfoById(id));
        return result;
    }

    @RequestMapping(value = "/getUserById/slave/{id}", method = RequestMethod.GET)
    @DataSource(mode = DataSourceMode.ASSIGN, type = DataSourceType.SLAVE1)
    public ResponseResult<User> getUserByIdSlave(@PathVariable(value = "id") Integer id){
        ResponseResult<User> result = new ResponseResult<>();
        result.setData(userService.getUserInfoById(id));
        return result;
    }

    @RequestMapping(value = "/masterTx/{id}", method = RequestMethod.GET)
    @DataSource(mode = DataSourceMode.ASSIGN, type = DataSourceType.MASTER)
    public ResponseResult<Boolean> masterTx(@PathVariable(value = "id") Integer id){
        ResponseResult<Boolean> result = new ResponseResult<>();
        userService.updateUpdated(id);
        result.setData(true);
        return result;
    }

    @RequestMapping(value = "/slaveTx/{id}", method = RequestMethod.GET)
    @DataSource(mode = DataSourceMode.ASSIGN, type = DataSourceType.SLAVE1)
    public ResponseResult<Boolean> slaveTx(@PathVariable(value = "id") Integer id){
        ResponseResult<Boolean> result = new ResponseResult<>();
        userService.updateUpdated(id);
        result.setData(true);
        return result;
    }

}
