package com.solverpeng.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Main {
    @Bean
    public WebMvcConfigurer configure () {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings (CorsRegistry registry) {
                registry.addMapping("/test2")
                        .allowedOrigins("http://localhost:9000")
                        .allowedMethods("GET", "POST");
            }
        };
    }

    public static void main (String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
