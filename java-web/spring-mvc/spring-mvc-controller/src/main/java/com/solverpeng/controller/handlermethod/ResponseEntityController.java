package com.solverpeng.controller.handlermethod;

import com.solverpeng.bean.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/responseEntity")
public class ResponseEntityController {

    // 需要提供类型转换器
    @GetMapping("/handle")
    public ResponseEntity<Person> handle() {
        Person person = new Person();
        person.setName("tom");
        person.setAge(22);
        return ResponseEntity.ok(person);
    }

}
