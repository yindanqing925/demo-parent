package org.nh.boot.test.service;

import java.util.concurrent.Future;

/**
 * AsyncService
 *
 * @Author yindanqing
 * @Description TODO
 * @Date 2019/6/11 19:56
 */
public interface AsyncService {

    /**
     * async无返回值
     */
    void asyncMethodWithVoidReturnType() throws InterruptedException;

    /**
     * async有返回值
     */
    Future<String> asyncMethodWithReturnType() throws InterruptedException;

}
