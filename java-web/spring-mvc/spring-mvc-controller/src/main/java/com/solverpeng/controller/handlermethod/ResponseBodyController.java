package com.solverpeng.controller.handlermethod;

import com.solverpeng.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/responseBody")
public class ResponseBodyController {

    // 缺少类型转换器
    @ResponseBody
    @GetMapping("/handle")
    public Person handle() {
        Person person = new Person();
        person.setName("tom");
        person.setAge(22);
        return person;
    }

}
