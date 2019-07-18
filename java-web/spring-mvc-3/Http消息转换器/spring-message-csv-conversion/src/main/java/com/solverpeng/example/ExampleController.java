package com.solverpeng.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExampleController {
    @RequestMapping(
            value = "/newEmployee",
            consumes = "text/csv",
            produces = MediaType.TEXT_PLAIN_VALUE,
            method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String handleRequest (@RequestBody EmployeeList employeeList) {
        System.out.printf("In handleRequest method, employeeList: %s%n", employeeList.getList());
        String s = String.format("size: " + employeeList.getList().size());
        System.out.println(s);
        return s;
    }
}
