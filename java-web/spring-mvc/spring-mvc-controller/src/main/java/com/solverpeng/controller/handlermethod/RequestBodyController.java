package com.solverpeng.controller.handlermethod;

import com.solverpeng.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/requestBody")
public class RequestBodyController {

    // 需要提供类型转换器
    @ResponseBody
    @PostMapping("/person")    public String handle(@RequestBody Person person) {
        return "requestBody->person:" + person;
    }
}
