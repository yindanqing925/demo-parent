package org.nh.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: IndexPageController.java
 * @description: 登录及主页
 * @author: yindanqing
 * @create: 2019/12/4 11:47
 */
@Controller
@RequestMapping
public class PrePageController {

    @RequestMapping(value = "/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/index")
    public String toIndex(){
        return "index/index";
    }

}
