package com.solverpeng.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class TestController2 {
    @Autowired
    ApplicationContext context;

    @ResponseBody
    @RequestMapping
    public String handleRequest () {
        return "response2 from /test";
    }

}
