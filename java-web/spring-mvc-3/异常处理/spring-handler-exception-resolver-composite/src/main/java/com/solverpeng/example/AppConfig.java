package com.solverpeng.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Arrays;
import java.util.Properties;

@EnableWebMvc
@ComponentScan
public class AppConfig {
    @Bean
    HandlerExceptionResolver exceptionResolverComposite () {
        HandlerExceptionToViewResolver r = new HandlerExceptionToViewResolver();

        SimpleMappingExceptionResolver s = new SimpleMappingExceptionResolver();
        s.setDefaultErrorView("default-error-page");
        Properties p = new Properties();
        p.setProperty(IllegalAccessException.class.getName(), "simple-test-error-view");
        s.setExceptionMappings(p);

        org.springframework.web.servlet.handler.HandlerExceptionResolverComposite c = new org.springframework.web.servlet.handler.HandlerExceptionResolverComposite();
        c.setExceptionResolvers(Arrays.asList(r, s));
        return c;
    }

    @Bean
    public ViewResolver viewResolver () {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
