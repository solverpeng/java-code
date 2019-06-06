package com.solverpeng.springboot.config;

import com.solverpeng.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    @Bean
    public HelloService helloService() {
        return new HelloService();
    }
}
