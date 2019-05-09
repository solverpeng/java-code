package com.solverpeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWordController {

    @RequestMapping("/hello")
    public void helloWorld() {
        System.out.println("hello world!");
    }

}
