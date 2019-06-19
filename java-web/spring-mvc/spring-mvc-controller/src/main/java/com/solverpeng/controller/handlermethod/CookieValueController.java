package com.solverpeng.controller.handlermethod;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookieValue")
public class CookieValueController {

    @GetMapping("/jsessionid")
    public String handler(@CookieValue("JSESSIONID") String cookie) {
        return "cookieValue->jsessionid:" + cookie;
    }
}
