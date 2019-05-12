package com.solverpeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebApplicationContextController {

    @RequestMapping("/listWebApplicationContext")
    public void listWebApplicationContext(HttpServletRequest request) {
        WebApplicationContext webApplicationContext = RequestContextUtils.findWebApplicationContext(request);
        System.out.println(webApplicationContext);
    }
}
