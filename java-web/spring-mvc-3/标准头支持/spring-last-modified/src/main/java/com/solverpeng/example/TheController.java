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
    public static long getResourceLastModified() {
        ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.of(2017, 1, 9,
                10, 30, 20),
                ZoneId.of("GMT"));
        return zdt.toInstant().toEpochMilli();
    }

    @RequestMapping(value = "/test1")
    public String handle1(ServletWebRequest swr) {

        //doesn't matter it returns false/true it will set the required headers automatically.
        //It doesn't include 'Cache-Control:no-cache' so have to do browser F5
        if (swr.checkNotModified(getResourceLastModified())) {
            //it will return 304 with empty body
            return null;
        }
        System.out.println("check pass.");

        //uncomment the following if last-modified checking is needed at every action
       /* swr.getResponse().setHeader(HttpHeaders.CACHE_CONTROL,
                                    CacheControl.noCache()
                                                .getHeaderValue());*/

        return "myView";
    }

    @ResponseBody
    @RequestMapping(value = "/test2")
    public String handle2(WebRequest swr) {

        if (swr.checkNotModified(getResourceLastModified())) {
            return null;
        }

        String testBody = "<p>Response time: " + LocalDateTime.now() +
                "</p><a href='test2'>test2</a>";

        return testBody;
    }

    @ResponseBody
    @RequestMapping(value = "/test3")
    public ResponseEntity<String> handle3(WebRequest swr) {

        String testBody = "<p>Response time: " + LocalDateTime.now() +
                "</p><a href='test3'>test3</a>";

        //returning ResponseEntity with lastModified, HttpEntityMethodProcessor will
        //take care of populating/processing the required headers.
        //As the body can be replaced with empty one and 304 status can be send back,
        // this approach should be avoided if preparing the response body is very expensive.
        return ResponseEntity.ok()
                .lastModified(getResourceLastModified())
                .body(testBody);
    }
}
