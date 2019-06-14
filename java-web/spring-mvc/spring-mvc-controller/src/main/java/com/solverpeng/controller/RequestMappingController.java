package com.solverpeng.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(("/requestMapping"))
public class RequestMappingController {

    @GetMapping("/get/{id}")
    public String getMapping(@PathVariable("id") Integer id) {
        return "getMapping -> id:" + id ;
    }

    @PostMapping("/post")
    public String postMapping(){
        return "postMapping";
    }

    @PutMapping("/put/{id}")
    public String putMapping(@PathVariable("id") Integer id){
        return "putMapping -> id:" + id;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMapping(@PathVariable("id") Integer id) {
        return "deleteMapping -> id:" + id;
    }

    @PatchMapping("/patch/{id}")
    public String patchMapping(@PathVariable("id") Integer id) {
        return "patchMapping -> id:" + id;
    }

    @GetMapping("/uri/index?")
    public String uriPatternMapping() {
        return "/uri/index?";
    }

    @GetMapping("/uri/index*")
    public String uriPattern2Mapping() {
        return "/uri/index*";
    }

    @GetMapping("/uri/index/*")
    public String uriPattern3Mapping() {
        return "/uri/index/*";
    }

    @GetMapping("/uri/index/**")
    public String uriPattern4Mapping() {
        return "/uri/index/**";
    }

    @GetMapping("/pathVariable/{ownerId}/pets/{petId}")
    public String pathVariableMapping(@PathVariable Long ownerId, @PathVariable Long petId) {
        return "pathVariableMapping -> ownerId:" + ownerId + ",petId:" + petId;
    }

    @GetMapping("/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")
    public String  regexMapping(@PathVariable String version, @PathVariable String ext) {
        return "regexMapping-> version:" + version + ",ext:" + ext;
    }


    @GetMapping("/suffixMatch/person.json")
    public String SuffixMatch(String name) {
        return "suffixMatch->name:" + name;
    }

    @GetMapping(value = "/consumes", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String consumesMapping() {
        return "consumesMapping";
    }

    @GetMapping(value = "/produces", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String producesMapping() {
        return "producesMapping";
    }

    /**
     * 必须存在myParam参数，且值为myValue
     */
    @GetMapping(value = "/requestParam/{id}", params = {"myParam=myValue"})
    public String requestParam(@PathVariable String id, String myParam) {
        return "requestParam->id:" + id + ",myParam:" + myParam;
    }

    /**
     * 必须存在myParam参数
     */
    @GetMapping(value = "/requestParam2/{id}", params = {"myParam"})
    public String requestParam2(@PathVariable String id, String myParam) {
        return "requestParam2->id:" + id + ",myParam:" + myParam;
    }

    /**
     * 不存在myParam参数
     */
    @GetMapping(value = "/requestParam3/{id}", params = {"!myParam"})
    public String requestParam3(@PathVariable String id, String myParam) {
        return "requestParam3->id:" + id + ",myParam:" + myParam;
    }

}
