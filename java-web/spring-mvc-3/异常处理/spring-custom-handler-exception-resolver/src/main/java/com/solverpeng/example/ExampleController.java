package com.solverpeng.example;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.OperationNotSupportedException;

@Controller
public class ExampleController {
    @ErrorView(value = "test-error-view", status = HttpStatus.GONE)
    @RequestMapping("/test")
    public String handleRequest () throws Exception {
        throw new Exception("test exception");
    }

    @RequestMapping("/test2")
    public String handleRequest2 () throws Exception {
        throw new OperationNotSupportedException("exception thrown in test2");
    }

    @ExceptionHandler
    @ResponseBody
    public String handleException (OperationNotSupportedException e) {
        return "exception :" + e.toString();
    }
}
