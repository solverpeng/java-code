package com.solverpeng.controller.handlermethod;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/sessionAttribute")
public class SessionAttributeController {
    @RequestMapping("/add")
    public String addToSessionAttribute(HttpSession session) {
        session.setAttribute("name", "zhangsan");
        return "sessionAttribute:HttpSession->add->name:zhangsan";
    }

    @RequestMapping("/add2")
    public String addToSessionAttribute2(WebRequest webRequest) {
        webRequest.setAttribute("age", 22, WebRequest.SCOPE_SESSION);
        return "sessionAttribute:WebRequest->add->age:22";
    }

    @RequestMapping("/get")
    public String get(@SessionAttribute("name") String name, @SessionAttribute("age") int age) {
        return "sessionAttribute:get->name=" + name + ",age=" + age;
    }

}
