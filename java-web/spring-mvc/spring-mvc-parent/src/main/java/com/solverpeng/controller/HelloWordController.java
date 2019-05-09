package com.solverpeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWordController {

    @RequestMapping("/hello")
    public void helloWorld() {
        System.out.println("hello world!");
    }

    @RequestMapping("/encoding")
    public void encoding(HttpServletRequest request, HttpServletResponse response) {
        String characterEncoding = request.getCharacterEncoding();
        String name = request.getParameter("name");
        System.out.println("name=" + name + ", characterEncoding=" + characterEncoding);
    }

}
