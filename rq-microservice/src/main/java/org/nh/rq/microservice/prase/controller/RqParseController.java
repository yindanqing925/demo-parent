package org.nh.rq.microservice.prase.controller;

import org.nh.demo.common.web.ResponseResult;
import org.nh.rq.microservice.prase.service.RqParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: RqPraseController.java
 * @description:
 * @author: yindanqing
 * @create: 2020/6/29 11:35
 */
@RestController
@RequestMapping(value = "/rq/parse")
public class RqParseController {

    @Autowired
    private RqParseService rqParseService;

    @RequestMapping(value = "/getRoomRqInfo/{roomNo}", method = RequestMethod.GET)
    public ResponseResult<String> getRoomRqInfo(@PathVariable(value = "roomNo") String roomNo){
        String roomRqInfo = rqParseService.getRoomRqInfo(roomNo);
        return new ResponseResult<String>(roomRqInfo);
    }

    @RequestMapping(value = "/getCheckInfo/{idNo}", method = RequestMethod.GET)
    public ResponseResult<String> getCheckInfo(@PathVariable(value = "idNo") String idNo){
        String checkInfo = rqParseService.getCheckInfo(idNo);
        return new ResponseResult<String>(checkInfo);
    }

}
