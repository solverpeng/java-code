package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
    @RequestMapping("/check")
    @ResponseBody
    public String check() {
        return "success";
    }
}
