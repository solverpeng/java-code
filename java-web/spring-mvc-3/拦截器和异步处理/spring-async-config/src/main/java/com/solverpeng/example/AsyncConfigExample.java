package com.solverpeng.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AsyncConfigExample {
    @Bean
    WebMvcConfigurer configurer () {
        return new WebMvcConfigurer() {
            @Override
            public void configureAsyncSupport (AsyncSupportConfigurer configurer) {
                ThreadPoolTaskExecutor t = new ThreadPoolTaskExecutor();
                t.setCorePoolSize(10);
                t.setMaxPoolSize(100);
                t.setQueueCapacity(50);
                t.setAllowCoreThreadTimeOut(true);
                t.setKeepAliveSeconds(120);
                t.initialize();
                configurer.setTaskExecutor(t);
            }
        };
    }

    public static void main (String[] args) {
        SpringApplication.run(AsyncConfigExample.class, args);
    }
}
