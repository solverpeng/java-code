package com.solverpeng.controller.handlermethod;

import com.solverpeng.bean.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/httpEntity")
public class HttpEntityController {
    /**
     * 同样也需要提供类型转换器
     */
    @ResponseBody
    @RequestMapping("/index")
    public String handle(HttpEntity<Person> personHttpEntity) {
        HttpHeaders headers = personHttpEntity.getHeaders();
        System.out.println(headers);
        Person person = personHttpEntity.getBody();
        System.out.println(person);
        return "httpEntity->personHttpEntity:" + personHttpEntity;
    }

}
