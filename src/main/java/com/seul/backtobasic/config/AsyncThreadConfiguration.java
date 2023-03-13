package com.seul.backtobasic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class AsyncThreadConfiguration {

//    @Bean
//    public Executor asyncThreadTaskExecutor() {
//        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.setCorePoolSize(8);
//        threadPoolTaskExecutor.setMaxPoolSize(8);
//        threadPoolTaskExecutor.setThreadNamePrefix("seul-executor-v1-");
//        return threadPoolTaskExecutor;
//    }
}
