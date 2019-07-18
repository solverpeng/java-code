package com.solverpeng.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/message")
public class MyController {

    @RequestMapping(
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.TEXT_HTML_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public String handleRequest(@RequestBody byte[] bytes) {
        System.out.println("body in bytes:" + bytes);
        return "<html><body><h1>Hi tom!</h1></body></html>";
    }

    @RequestMapping(
            value = "/string",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.TEXT_HTML_VALUE,
            method = RequestMethod.GET)
    @ResponseBody
    public String handleStringRequest(@RequestBody String str) {
        System.out.println("body in string:" + str);
        return "<html><body><h1>Hi jerry!</h1></body></html>";
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void handleFormRequest(@RequestBody MultiValueMap<String, String> formParams) {
        System.out.println("form params received " + formParams);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void handleFormPutRequest(@RequestBody MultiValueMap<String, String> formParams){
        System.out.println("form params received " + formParams);
    }

}
