package com.solverpeng.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters (List<HttpMessageConverter<?>> converters) {
        converters.add(new CsvHttpMessageConverter<>());
    }

}
