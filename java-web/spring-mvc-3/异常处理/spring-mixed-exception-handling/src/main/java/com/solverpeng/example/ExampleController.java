package com.solverpeng.example;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.OperationNotSupportedException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ExampleController {
    @RequestMapping("/test1")
    public String handleRequest1 (Model model) throws Exception {
        model.addAttribute("handler", "handleRequest1");
        throw new RuntimeException("test exception 1");
    }

    @RequestMapping("/test2/{id}")
    public String handleRequest2 (@PathVariable("pid") String id,
                                  Model model) throws Exception {
        model.addAttribute("handler", "handleRequest2");
        return "exception-page";
    }

    @RequestMapping("/test3")
    @ResponseBody
    public String handleRequest3 (Model model) {
        model.addAttribute("handler", "handleRequest3");
        int i = 20 / 0;
        return "testId: " + i;
    }

    @RequestMapping("/test4")
    public String handleRequest4 (Model model) throws Exception {
        model.addAttribute("handler", "handleRequest4");
        throw new Exception("test exception");
    }

    @RequestMapping("/errorHandler")
    public String handleRequest5 (Model model) throws Exception {
        model.addAttribute("handler", "errorHandler");
        return "exception-page";
    }

    @RequestMapping("/test6")
    public String handleRequest6 (Model model) throws Exception {
        model.addAttribute("handler", "handleRequest6");
        throw new OperationNotSupportedException("test exception 6");
    }

    @RequestMapping("/test7")
    public String handleRequest7 (Model model) throws Exception {
        model.addAttribute("handler", "handleRequest7");
        throw new IllegalAccessException("test exception 7");
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    @ExceptionHandler
    public String handleLocalException (OperationNotSupportedException e,
                                        Model model, HttpServletRequest r) {
        model.addAttribute("handler", "handleLocalException with @ExceptionHandler");
        return "exception-page";
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler
    public String handleLocalException2 (IllegalAccessException e,
                                         Model model) {
        model.addAttribute("handler", "handleLocalException2 with @ExceptionHandler");
        return "exception-page";
    }
}
