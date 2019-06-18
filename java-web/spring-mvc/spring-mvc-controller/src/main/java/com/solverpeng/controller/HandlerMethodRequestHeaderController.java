package com.solverpeng.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/requestHeader")
public class HandlerMethodRequestHeaderController {

    @GetMapping("/headers")
    public String handle(@RequestHeader("Accept-Encoding") String encoding,
                         @RequestHeader("Keep-Alive") long keepAlive,
                         @RequestHeader("Host") String host,
                         @RequestHeader("Accept") String accept) {
        return "requestHeader->encoding:" + encoding + ", keepAlive:" + keepAlive + ", Host:" + host + ",Accept:" + accept;
    }

    @GetMapping("/map")
    public String handle2(@RequestHeader Map<String, String> map) {
        return "requestHeader->map:" + map;
    }

    @GetMapping("/map2")
    public String handle3(@RequestHeader MultiValueMap<String, String> map) {
        return "requestHeader->multiValueMap:" + map;
    }

    @GetMapping("/httpHeaders")
    public String handle4(@RequestHeader HttpHeaders httpHeaders) {
        return "requestHeader->httpHeaders:" + httpHeaders;
    }

    /**
     *
     * @param accepts
     * @return
     */
    @GetMapping("/multiHeader")
    public String handle5(@RequestHeader("Accept") List<String> accepts) {
        return "requestHeader->accepts:" + accepts;
    }

}
