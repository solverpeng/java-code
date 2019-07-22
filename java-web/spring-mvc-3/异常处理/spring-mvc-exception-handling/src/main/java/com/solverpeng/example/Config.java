package com.solverpeng.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@EnableWebMvc
@ComponentScan
public class Config {
    @Bean
    HandlerExceptionResolver errorHandler () {
        return new HandlerExceptionResolver() {
            @Override
            public ModelAndView resolveException (HttpServletRequest request,
                                                  HttpServletResponse response,
                                                  Object handler,
                                                  Exception ex) {
                ModelAndView model = new ModelAndView("error-page");
                model.addObject("exceptionType", ex);
                model.addObject("handlerMethod", handler);
                return model;
            }
        };
    }

    //registering an interceptor
    @Bean
    public WebMvcConfigurer webMvcConfigurer () {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors (InterceptorRegistry registry) {
                registry.addInterceptor(new HandlerInterceptorAdapter() {
                    @Override
                    public boolean preHandle (HttpServletRequest request,
                                              HttpServletResponse response,
                                              Object handler) throws Exception {
                        if (request.getParameter("testParam") != null) {
                            throw new Exception("exception from interceptor");
                        }
                        return true;
                    }
                });
            }
        };
    }

    @Bean
    public ViewResolver viewResolver () {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
