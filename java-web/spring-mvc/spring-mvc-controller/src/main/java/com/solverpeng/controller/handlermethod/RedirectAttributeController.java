package com.solverpeng.controller.handlermethod;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/redirectAttribute")
public class RedirectAttributeController {

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("uriTemplateKey", "uriTemplateValue");
        model.addAttribute("normalKey", "normalValue");
        return "redirect:/redirectAttribute/redirect/{uriTemplateKey}";
    }

    // 重定向后：http://localhost:8080/spring_mvc_controller/redirectAttribute/redirect/uriTemplateValue?normalKey=normalValue
    @ResponseBody
    @GetMapping("/redirect/{uriTemplateKey}")
    public String redirect(@PathVariable String uriTemplateKey, @RequestParam String normalKey) {
        return "redirectAttribute->redirect->uriTemplateKey:" + uriTemplateKey + ",normalKey:" + normalKey;
    }

    @RequestMapping("/index2")
    public String index2(Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("normalKey", "normalValue");
        redirectAttributes.addAttribute("redirectAttributeKey", "redirectAttributeValue");
        return "redirect:/redirectAttribute/ignoreDefaultModel";
    }

    //重定向后：http://localhost:8080/spring_mvc_controller/redirectAttribute/ignoreDefaultModel?redirectAttributeKey=redirectAttributeValue
    //返回值如下：/redirectAttribute/ignoreDefaultModel->normalKey:null,redirectAttributeKey:redirectAttributeValue
    @ResponseBody
    @GetMapping("/ignoreDefaultModel")
    public String ignoreDefaultModel(HttpServletRequest request) {
        String normalKey = request.getParameter("normalKey");
        String redirectAttributeKey = request.getParameter("redirectAttributeKey");
        return "/redirectAttribute/ignoreDefaultModel->normalKey:" + normalKey + ",redirectAttributeKey:" + redirectAttributeKey;
    }


    // 请求：http://localhost:8080/spring_mvc_controller/redirectAttribute/index3/uriTemplateValue
    @RequestMapping("/index3/{uriTemplateKey}")
    public String index3() {
        return "redirect:/redirectAttribute/uriTemplateIgnoreDefaultModel/{uriTemplateKey}";
    }

    //重定向后：http://localhost:8080/spring_mvc_controller/redirectAttribute/uriTemplateIgnoreDefaultModel/uriTemplateValue
    //返回值：/redirectAttribute/uriTemplateIgnoreDefaultModel->uriTemplateKey:uriTemplateValue
    @ResponseBody
    @GetMapping("/uriTemplateIgnoreDefaultModel/{uriTemplateKey}")
    public String uriTemplateIgnoreDefaultModel(@PathVariable String uriTemplateKey) {
        return "/redirectAttribute/uriTemplateIgnoreDefaultModel->uriTemplateKey:" + uriTemplateKey;
    }
}
