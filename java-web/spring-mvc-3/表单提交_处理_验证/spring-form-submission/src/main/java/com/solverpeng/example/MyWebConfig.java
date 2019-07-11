package com.solverpeng.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan
@Import(MyViewConfig.class)
@EnableWebMvc
public class MyWebConfig {

    @Bean
    public UserService userService() {
        return new InMemoryUserService();
    }

}
