package com.solverpeng.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Autowired
    private ApplicationContext context;

    @RequestMapping("/publish")
    @ResponseBody
    public String  publishEvent() {
        ApplicationEvent event = new ContextStartedEvent(context);
        context.publishEvent(event);
        return "success";
    }
}
