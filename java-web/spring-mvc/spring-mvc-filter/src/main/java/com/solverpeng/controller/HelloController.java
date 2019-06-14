package com.solverpeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String hello(String name) {
        return "hello->" + name;
    }

    @RequestMapping(value = "/hello2")
    public String hello2(@RequestParam("name") String name, HttpServletRequest request) {
        request.setAttribute("name", name);
        return "hello";
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.PUT)
    public String hello3(HttpServletRequest request) {
        String name = request.getParameter("name");
        return "hello->" + name;
    }

}
