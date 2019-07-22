package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {
    @RequestMapping("/test/{id}")
    @ResponseBody
    public String handleRequest (@PathVariable("testId") String id) throws Exception {
        return "testId: " + id;
    }

    @RequestMapping("/test2")
    public String handleRequest () throws Exception {
        throw new BindException(new Object(), "test");
    }
}
