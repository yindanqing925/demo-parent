package org.nh.shiro.dict.rest;

import com.github.pagehelper.PageInfo;
import org.nh.demo.common.web.ResponseResult;
import org.nh.shiro.dict.condition.ShiroDictListCond;
import org.nh.shiro.dict.domian.ShiroDict;
import org.nh.shiro.dict.service.ShiroDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: DictController.java
 * @description:
 * @author: yindanqing
 * @create: 2019/12/4 14:48
 */
@RestController
@RequestMapping("/rest/dict")
public class DictController {

    @Autowired
    private ShiroDictService shiroDictService;

    @RequestMapping(value = "/findDictList", method = RequestMethod.POST)
    public ResponseResult<PageInfo<ShiroDict>> findDictList(@RequestBody(required = false) ShiroDictListCond dictListCond) {
        return new ResponseResult<>(shiroDictService.findDictList(dictListCond));
    }

    @RequestMapping(value = "/modifyTransferDict", method = RequestMethod.POST)
    public ResponseResult<Integer> modifyTransferDict(@RequestBody(required = false) ShiroDict shiroDict) {
        return new ResponseResult<>(shiroDictService.modifyShiroDict(shiroDict));
    }

    @RequestMapping(value = "/addTransferDict", method = RequestMethod.POST)
    public ResponseResult<Integer> addTransferDict(@RequestBody(required = false) ShiroDict shiroDict) {
        return new ResponseResult<>(shiroDictService.addShiroDict(shiroDict));
    }

}
