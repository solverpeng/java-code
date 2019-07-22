package com.solerpeng.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class Main {
    public static void main (String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    @SpringBootApplication
    public static class BootApplication implements WebMvcConfigurer {
        @Override
        public void addInterceptors (InterceptorRegistry registry) {
            registry.addInterceptor(new MyAsyncHandlerInterceptor());
        }
    }
}
