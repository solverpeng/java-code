package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyMvcController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String prepareView(Model model) {
        model.addAttribute("msg", "Spring quick start!!");
        return "my-page";
    }
}
