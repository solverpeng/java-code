package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {
    @RequestMapping("/products/**")
    public String handleRequest() {
        return "app-page";
    }
}
