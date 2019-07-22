package com.solverpeng.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @Autowired
    private DataService dataService;

    @RequestMapping("/order/{orderId}")
    public String handleRequest (@PathVariable("orderId") String orderId,
                                 Model model) {
        return dataService.getOrderDetail(orderId);
    }

    @RequestMapping("/data/{id}")
    public String testHandler (@PathVariable("id") String id,
                               Model model) {
        return dataService.getData(id);
    }

    @RequestMapping("/test")
    public void testHandler2 () {
        throw new RuntimeException("test exception");
    }
}
