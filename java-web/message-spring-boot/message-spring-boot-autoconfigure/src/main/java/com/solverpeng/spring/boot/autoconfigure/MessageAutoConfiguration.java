package com.solverpeng.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({MessageProperties.class})
public class MessageAutoConfiguration {

    private final MessageProperties properties;


    public MessageAutoConfiguration(MessageProperties properties) {
        this.properties = properties;
    }
}
