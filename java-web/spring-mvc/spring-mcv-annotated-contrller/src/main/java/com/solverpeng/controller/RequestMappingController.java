package com.solverpeng.controller;

import com.solverpeng.bean.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class RequestMappingController {

    // 混用通配和路径变量
    @GetMapping("/ant5/**/{name}")
    public String ant5(@PathVariable String name) {
        return "ant+url " + name;
    }

    // 基于正则的URL映射
    @PostMapping("/{name:\\w+}-{age:\\d+}")
    public void regex(@PathVariable String name, @PathVariable int age) {
        System.out.println("name:" + name + ", age:" + age);
    }

    // 通配符: ? 匹配一个字符，* 匹配0个或多个字符在一个路径段中， ** 匹配0个或多个路径段
    @GetMapping("/ant1?")
    public String wildcards1() {
        return "ant1?";
    }

    @GetMapping("/ant2*")
    public String wildcards2() {
        return "ant2*";
    }

    @GetMapping("/ant3/**")
    public String wildcards3() {
        return "ant3/**";
    }

    // 路径变量，也可以在类级别的URL变量中声明
    @GetMapping("/{id}/pets/{petId}")
    public Person findPerson(@PathVariable Long id, @PathVariable Long petId) {
        return new Person();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {

        return new Person();
    }

    // 映射方法
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Person person) {
        System.out.println(person);
    }

}
