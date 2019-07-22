package com.solverpeng.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan
public class AppConfig {
    /* @Bean
    public HandlerExceptionResolver theResolver(){
        SimpleMappingExceptionResolver s = new SimpleMappingExceptionResolver();
        s.setDefaultErrorView("default-error-page2");
        return s;
    }*/
    @Bean
    public ViewResolver viewResolver () {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    @Bean
    public WebMvcConfigurer webConfigurer () {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers (ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/static/**")
                        .addResourceLocations("/static/");
            }
        };
    }
}
