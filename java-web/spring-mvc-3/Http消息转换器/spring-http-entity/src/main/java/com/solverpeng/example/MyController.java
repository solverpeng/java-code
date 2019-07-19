package com.solverpeng.example;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping
public class MyController {

    @RequestMapping
    public HttpEntity handleRequest(HttpEntity<String> requestEntity) {
        System.out.println("request body: " + requestEntity.getBody());
        HttpHeaders headers = requestEntity.getHeaders();
        System.out.println("request headers " + headers);
        return new HttpEntity<>("my response body");
    }


    @RequestMapping("/user")
    public HttpEntity<String> handleUserRequest(HttpEntity<User> requestEntity) {
        User user = requestEntity.getBody();
        System.out.println("request body: " + user);
        System.out.println("request headers " + requestEntity.getHeaders());

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.put("Cache-Control", Arrays.asList("max-age=3600"));

        return new HttpEntity<>("my response body", headers);
    }


}
