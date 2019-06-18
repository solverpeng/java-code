package com.solverpeng.controller;

import com.solverpeng.bean.Address;
import com.solverpeng.bean.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modelAttribute")
public class HandlerMethodModelAttributeController {

    @ModelAttribute
    public Address getAddress(@PathVariable(required = false) String userId) {
        Address address = new Address();
        address.setAddressName("beijing");
        address.setEmail("beijing@163.com");
        return address;
    }

    @GetMapping("/modelAttributeMethod")
    public String modelAttributeMethod(@ModelAttribute Address address) {
        return "modelAttributeMethod->address:" + address;
    }


    @RequestMapping("/defaultConstructor")
    public String defaultConstructor(@ModelAttribute Person person) {
        return "modelAttribute->defaultConstructor:" + person;
    }

    @GetMapping("/bindServletRequestParam")
    public String bindServletRequestParam(@ModelAttribute Address address) {
        return "bindServletRequestParam->address:" + address;
    }

    /**
     * 表示不需要绑定数据
     */
    @PostMapping("/modelAttributeBindingFalse")
    public String modelAttributeBindingFalse(@ModelAttribute(binding = false) Person person) {
        return "modelAttributeBindingFalse->person:" + person;
    }



}
