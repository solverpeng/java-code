package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalTime;

@Controller
public class TheController {
    @CrossOrigin(origins = {"http://localhost:9000"})
    @RequestMapping("/test")
    @ResponseBody
    public String handle () {
        return "test response from spring handle() method . time: " + LocalTime.now();
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String handle2 () {
        return "test response from handle2(). time: " + LocalTime.now();
    }
}
