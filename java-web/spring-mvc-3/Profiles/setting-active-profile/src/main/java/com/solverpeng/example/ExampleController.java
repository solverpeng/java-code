package com.solverpeng.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {
    @Autowired
    private GreetingService greetingService;

    @RequestMapping("/profile")
    @ResponseBody
    public String handle() {
        return greetingService.getGreetingMsg();
    }
}
