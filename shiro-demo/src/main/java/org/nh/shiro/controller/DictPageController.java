package org.nh.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: DictPageController.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/4 11:49
 */
@Controller
@RequestMapping(value = "/dict")
public class DictPageController {

    @RequestMapping(value = "/dictList")
    public String dictList(){
        return "dict/dictList";
    }

    @RequestMapping(value = "/dictAdd")
    public String dictAdd(){
        return "dict/dictAdd";
    }

    @RequestMapping(value = "/dictEdit")
    public String dictEdit(){
        return "dict/dictEdit";
    }

}
