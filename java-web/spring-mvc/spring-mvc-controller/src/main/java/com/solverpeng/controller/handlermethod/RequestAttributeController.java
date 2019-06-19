package com.solverpeng.controller.handlermethod;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/requestAttribute")
public class RequestAttributeController {

    @ModelAttribute
    public void putRequestAttribute(HttpServletRequest request) {
        request.setAttribute("word", "helloWorld!");
    }

    @GetMapping("/get")
    public String getRequestAttribute(@RequestAttribute("word") String word) {
        return "requestAttribute->get:" + word;
    }

}
