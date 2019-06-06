package com.solverpeng.swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Hello World")
public class HelloSwagger2 {
    @ApiOperation(value = "hello", notes = "hello swagger2")
    @GetMapping("/helloSwagger2")
    public String hello() {
        return "success";
    }
}
