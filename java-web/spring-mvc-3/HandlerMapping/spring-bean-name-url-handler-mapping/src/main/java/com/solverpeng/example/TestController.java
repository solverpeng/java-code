package com.solverpeng.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/example")
public class TestController {
    @Autowired
    ApplicationContext context;

    @ResponseBody
    @RequestMapping
    public String handleRequest () {
        return "response from /test";
    }

}
