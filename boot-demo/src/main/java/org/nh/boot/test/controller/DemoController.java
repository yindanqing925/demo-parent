package org.nh.boot.test.controller;

import org.nh.demo.common.exception.BusinessException;
import org.nh.demo.common.web.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private Environment environment;

    @Value("${spring.application.name}")
    private String application;

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public ResponseResult<String> getName(){
        logger.info("request is here.");
        logger.info("application:" + environment.getProperty("spring.application.name"));
        logger.info("applicationName:" + environment.getProperty("applicationName"));
        return new ResponseResult<String>("success");
    }

    @RequestMapping(value = "/runtimeException", method = RequestMethod.GET)
    public ResponseResult<String> runtimeException(){
        logger.info("request is here:runtimeException");
        throw new RuntimeException("runtimeException");
    }

    @RequestMapping(value = "/businessException", method = RequestMethod.GET)
    public ResponseResult<String> businessException(){
        logger.info("request is here:businessException");
        throw new BusinessException(1999, "businessException1999");
    }

}
