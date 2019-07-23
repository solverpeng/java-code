package com.solverpeng.example;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Controller
public class TheController {
    @RequestMapping(value = "/test1")
    public String handle1 (ServletWebRequest swr) {

        if (swr.checkNotModified(getETag())) {
            //it will return 304 with empty body
            return null;
        }
        return "myView";
    }

    @ResponseBody
    @RequestMapping(value = "/test2")
    public String handle2 (WebRequest swr) {

        if (swr.checkNotModified(getETag())) {
            return null;
        }

        String testBody = "<p>Response time: " + LocalDateTime.now() +
                "</p><a href='test2'>test2</a>";

        return testBody;
    }

    @ResponseBody
    @RequestMapping(value = "/test3")
    public ResponseEntity<String> handle3 (WebRequest swr) {

        String version = getETag();

        String testBody = "<p>Response time: " + LocalDateTime.now() +
                "</p><a href='test3'>test3</a>";
        return ResponseEntity
                .ok()
                .eTag(version)
                .body(testBody);
    }

    public String getETag () {
        return "version1";
    }
}
