package org.nh.boot.config.executor;

import org.springframework.core.task.AsyncTaskExecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * ExceptionHandlingAsyncTaskExecutor
 *
 * @Author yindanqing
 * @Description TODO
 * @Date 2019/6/11 13:47
 */
public class ExceptionHandlingAsyncTaskExecutor implements AsyncTaskExecutor {

    private AsyncTaskExecutor executor;

    public ExceptionHandlingAsyncTaskExecutor(AsyncTaskExecutor executor) {
        this.executor = executor;
    }

    @Override
    public void execute(Runnable task) {
        executor.execute(createWrappedRunnable(task));
    }

    @Override
    public void execute(Runnable task, long startTimeout) {
        executor.execute(createWrappedRunnable(task), startTimeout);
    }

    @Override
    public Future submit(Runnable task) {
        return executor.submit(createWrappedRunnable(task));
    }

    @Override
    public Future submit(final Callable task) {
        return executor.submit(createCallable(task));
    }

    private <T> Callable createCallable(final Callable<T> task) {
        return () -> {
            try {
                return task.call();
            } catch (Exception ex) {
                handle(ex);
                throw ex;
            }
        };
    }

    private Runnable createWrappedRunnable(final Runnable task) {
        return () -> {
            try {
                task.run();
            } catch (Exception ex) {
                handle(ex);
            }
        };
    }

    private void handle(Exception ex) {
        //具体的异常逻辑处理的地方
        System.err.println("Error during @Async execution: " + ex);
    }
}
