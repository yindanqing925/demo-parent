package org.nh.shiro.controller;

import org.nh.shiro.dict.service.ShiroDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: DictPageController.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/4 11:49
 */
@Controller
@RequestMapping(value = "/page/dict")
public class DictPageController {

    @Autowired
    private ShiroDictService shiroDictService;

    @RequestMapping(value = "/dictList")
    public String dictList(){
        return "dict/dictList";
    }

    @RequestMapping(value = "/dictAdd")
    public String dictAdd(){
        return "dict/dictAdd";
    }

    @RequestMapping(value = "/dictEdit/{dictId}")
    public String dictEdit(HttpServletRequest request, @PathVariable(value = "dictId") Long dictId){
        request.setAttribute("dict", shiroDictService.getDictById(dictId));
        return "dict/dictEdit";
    }

}
