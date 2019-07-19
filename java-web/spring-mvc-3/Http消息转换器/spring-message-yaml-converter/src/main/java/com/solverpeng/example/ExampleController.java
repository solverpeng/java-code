package com.solverpeng.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExampleController {
    @RequestMapping(
            value = "/newEmployee",
            consumes = "text/yaml",
            produces = MediaType.TEXT_PLAIN_VALUE,
            method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String handleRequest (@RequestBody Employee employee) {
        System.out.printf("In handleRequest method, employee: %s%n", employee);
        String s = "Employee saved: " + employee.getName();
        System.out.println(s);
        return s;
    }

    @RequestMapping(
            value = "/employee",
            produces = "text/yaml",
            method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Employee handleRequest2 (@RequestParam String id) {
        //create a test employee
        return new Employee(id, "Tina", "111-111-1111");
    }
}
