package com.solverpeng.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @GetMapping("/customer")
    public String getCustomerInfo(CustomerInfo ci) {
        return ci.toString();
    }

    @GetMapping("/order")
    public String getCustomerInfo(OrderInfo oi) {
        return oi.toString();
    }
}
