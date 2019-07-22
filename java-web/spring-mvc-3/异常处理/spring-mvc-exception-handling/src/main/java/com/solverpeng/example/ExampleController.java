package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {
    @RequestMapping("/")
    public void handleRequest () {
        throw new RuntimeException();
    }

    @RequestMapping("/test")
    @ResponseBody
    public String testHandler () {
        return "test body";
    }
}
