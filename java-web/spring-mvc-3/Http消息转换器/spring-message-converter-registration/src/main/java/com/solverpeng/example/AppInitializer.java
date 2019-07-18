package com.solverpeng.example;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setServletContext(servletContext);
        context.register(AppConfig.class);

        ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("springDispatcherServlet", new DispatcherServlet(context));
        dispatcherServlet.addMapping("/");
        dispatcherServlet.setLoadOnStartup(1);
    }
}