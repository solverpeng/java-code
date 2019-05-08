package com.solverpeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonController {

    @ResponseBody
    @GetMapping("/getPerson")
    public String getPerson() {
        return "tom";
    }

}
