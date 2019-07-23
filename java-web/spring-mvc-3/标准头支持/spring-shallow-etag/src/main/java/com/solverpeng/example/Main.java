package com.solverpeng.example;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@ServletComponentScan
@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication sa = new SpringApplication(Main.class);
        sa.setLogStartupInfo(false);
        sa.setBannerMode(Banner.Mode.OFF);
        sa.run(args);
    }

    @Bean
    FilterRegistrationBean shallowEtagBean () {
        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setFilter(new ShallowEtagHeaderFilter());
        frb.addUrlPatterns("/test1", "/test2", "/public/myStaticPage.html");
        frb.setOrder(2);
        return frb;
    }

    @Bean
    FilterRegistrationBean headerLogger () {
        FilterRegistrationBean frb = new FilterRegistrationBean();
        frb.setFilter(new HeaderLogger());
        frb.addUrlPatterns("/test1", "/test2", "/public/myStaticPage.html");
        frb.setOrder(1);
        return frb;
    }
}
