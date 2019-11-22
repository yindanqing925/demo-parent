package org.nh.async.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.nh.async.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * AsyncServiceImpl
 *
 * @Author yindanqing
 * @Description TODO
 * @Date 2019/6/11 19:56
 */
@Service
@Slf4j
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async
    public void asyncMethodWithVoidReturnType() throws InterruptedException {
        log.info("asyncMethodWithVoidReturnType 开始" + Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info("asyncMethodWithVoidReturnType 结束" + Thread.currentThread().getName());
    }

    @Override
    public Future<String> asyncMethodWithReturnType() throws InterruptedException {
        String msg = "asyncMethodWithReturnType";
        log.info(msg + " 开始 " + Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info(msg + " 结束 " + Thread.currentThread().getName());
        return new AsyncResult<String>("asyncMethodWithReturnType 222");
    }

}
