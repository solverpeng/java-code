package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MyController {

    @RequestMapping(value = "/test/{id}")
    public String handleTestRequest(@PathVariable("id") String id,
            Model model) {
        if (!id.matches("\\d+")) {
            model.addAttribute("msg", "id should only num.");
            return "error-page";
        } else {
            model.addAttribute("attr", "attrValue");
            return "redirect:/test2/{id}";
        }

    }

    @RequestMapping("/test2/{id}")
    public String handleRequest (@PathVariable("id") String id,
                                 @RequestParam("attr") String attr,
                                 Model model) {
        model.addAttribute("id", id);
        model.addAttribute("attr", attr);
        return "my-page";
    }
}
