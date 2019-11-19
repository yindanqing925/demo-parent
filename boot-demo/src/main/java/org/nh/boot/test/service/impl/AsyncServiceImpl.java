package org.nh.boot.test.service.impl;

import org.nh.boot.test.service.AsyncService;
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
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async
    public void asyncMethodWithVoidReturnType() throws InterruptedException {
        System.out.println("asyncMethodWithVoidReturnType 111");
        Thread.sleep(2000);
        System.out.println("asyncMethodWithVoidReturnType 222");
    }

    @Override
    @Async
    public Future<String> asyncMethodWithReturnType() throws InterruptedException {
        System.out.println("asyncMethodWithReturnType 111 : " + Thread.currentThread().getName());
        Thread.sleep(2000);
        return new AsyncResult<String>("asyncMethodWithReturnType 222");
    }

}
