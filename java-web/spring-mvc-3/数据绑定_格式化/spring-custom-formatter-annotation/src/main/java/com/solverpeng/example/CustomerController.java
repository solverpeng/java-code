package com.solverpeng.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerDataService customerDataService;

    @RequestMapping(method = RequestMethod.GET)
    private String handleRequest (Model model) {
        model.addAttribute("customerList", customerDataService.getAllUsers());
        return "customers";
    }
}
