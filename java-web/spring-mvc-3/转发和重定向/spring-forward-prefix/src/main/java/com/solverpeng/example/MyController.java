package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @RequestMapping(value = "/test/{id}")
    public String handleTestRequest(@PathVariable("id") String id,
                                    Model model) {
        if (!id.matches("\\d+")) {
            model.addAttribute("msg", "id should only num.");
            return "error-page";
        } else {
            return "forward:/handleForward/" + id + "/?attr=attrValue";
        }

    }

    @RequestMapping("/handleForward/{id}")
    public String handleForward(@PathVariable("id") String id,
                                @RequestParam("attr") String attr,
                                Model model) {
        model.addAttribute("id", id);
        model.addAttribute("attr", attr);
        return "my-page";
    }

    @RequestMapping(value = "/test2/{id}")
    public String handleTestRequest2(@PathVariable("id") String id,
                                     Model model, HttpServletRequest request) {
        if (!id.matches("\\d+")) {
            model.addAttribute("msg", "id should only num.");
            return "error-page";
        } else {
            request.setAttribute("attr", "attrValue");
            return "forward:/handleForward2/" + id;
        }

    }

    @RequestMapping("/handleForward2/{id}")
    public String handleForward2(@PathVariable("id") String id,
                                 Model model,
                                 HttpServletRequest request) {
        model.addAttribute("id", id);
        model.addAttribute("attr", request.getAttribute("attr"));
        return "my-page";
    }
}
