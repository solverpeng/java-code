package com.solverpeng.springbootcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
public class I18nExampleController {

    @RequestMapping("/testI18n")
    @ResponseBody
    public String handleRequest(Locale locale) {
        System.out.println(String.format("I18n, locale country is %s, language is %s", locale.getCountry(), locale.getLanguage()));
        return "success";
    }
}
