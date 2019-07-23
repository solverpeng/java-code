package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController2 {
    @RequestMapping("/test2")
    public String handleRequest2 () throws Exception {
        String msg = String.format("Test exception from class: %s",
                this.getClass().getSimpleName());

        throw new RuntimeException(msg);
    }
}
