package com.solverpeng.example;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.OperationNotSupportedException;

@Controller
public class ExampleController {
    //should be handled by our custom resolver because of @ErrorView
    @ErrorView(value = "test-error-view", status = HttpStatus.GONE)
    @RequestMapping("/test1")
    public String handleRequest () throws Exception {
        throw new Exception("test exception 1");
    }

    //should be handled by handleException() because of @ExceptionHandler.
    //Default resolvers are processed before application registered ones
    @RequestMapping("/test2")
    public String handleRequest2 () throws Exception {
        throw new OperationNotSupportedException("test exception 2");
    }

    //should be handled by SimpleMappingExceptionResolver's default view
    @RequestMapping("/test3")
    public String handleRequest3 () throws Exception {
        throw new Exception("test exception 3");
    }

    //should be handled by SimpleMappingExceptionResolver:
    //IllegalAccessException is mapped to 'test-error-view'
    @RequestMapping("/test4")
    public String handleRequest4 () throws Exception {
        throw new IllegalAccessException("test exception 4");
    }

    //should be handled by our custom resolver even though IllegalAccessException
    //is mapped in SimpleMappingExceptionResolver. Reasons is: in iteration order
    // our custom resolver is first to process
    @ErrorView(value = "test-error-view", status = HttpStatus.FORBIDDEN)
    @RequestMapping("/test5")
    public String handleRequest5 () throws Exception {
        throw new IllegalAccessException("test exception 5");
    }

    @ExceptionHandler
    @ResponseBody
    public String handleException (OperationNotSupportedException e) {
        return "exception :" + e.toString();
    }}
