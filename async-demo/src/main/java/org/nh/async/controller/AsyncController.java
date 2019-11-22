package org.nh.async.controller;

import org.nh.async.service.AsyncService;
import org.nh.common.web.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * AsyncController
 *
 * @Author yindanqing
 * @Description TODO
 * @Date 2019/6/11 20:01
 */
@RestController
@RequestMapping(value = "/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping(value = "/getName", method = RequestMethod.GET)
    public ResponseResult<String> getName() throws InterruptedException, ExecutionException {
        asyncService.asyncMethodWithVoidReturnType();
        Future<String> future = asyncService.asyncMethodWithReturnType();
        return new ResponseResult<String>(future.get());
    }

}
