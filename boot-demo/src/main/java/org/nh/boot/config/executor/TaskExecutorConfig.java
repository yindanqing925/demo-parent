package org.nh.boot.config.executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * TaskExecutor
 *
 * @Author yindanqing
 * @Description TODO
 * @Date 2019/6/11 20:05
 */
@Configuration
public class TaskExecutorConfig {

    private static final int MAX_POOL_SIZE = 50;

    private static final int CORE_POOL_SIZE = 20;

    @Bean
    public TaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(MAX_POOL_SIZE);
        taskExecutor.setCorePoolSize(CORE_POOL_SIZE);
        taskExecutor.setThreadNamePrefix("async-task-thread-pool");
        taskExecutor.initialize();
        return new ExceptionHandlingAsyncTaskExecutor(taskExecutor);
    }

}
