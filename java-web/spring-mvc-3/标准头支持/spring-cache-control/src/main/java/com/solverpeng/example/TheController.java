package com.solverpeng.example;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Controller
public class TheController {
    @RequestMapping(value = "/test1")
    public String handle1 (HttpServletResponse response) {
        String headerValue = CacheControl.maxAge(10, TimeUnit.SECONDS)
                .getHeaderValue();

        response.addHeader("Cache-Control", headerValue);
        return "myView";
    }

    @ResponseBody
    @RequestMapping(value = "/test2")
    public ResponseEntity<String> handle2 () {

        CacheControl cacheControl = CacheControl.maxAge(10, TimeUnit.SECONDS);

        String testBody = "<p>Response time: " + LocalDateTime.now() +
                "</p><a href=''>test2</a>";
        return ResponseEntity.ok()
                .cacheControl(cacheControl)
                .body(testBody);
    }
}
