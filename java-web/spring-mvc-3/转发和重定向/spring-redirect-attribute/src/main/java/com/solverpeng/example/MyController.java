package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    @RequestMapping(value = "test/{id}")
    public String handleTestRequest (@PathVariable("id") String id, Model model,
                                     RedirectAttributes ra) {
        if (!id.matches("\\d+")) {
            model.addAttribute("msg", "id should only have digits");
            return "error-page";
        } else {
            ra.addAttribute("attr", "attrVal");
            ra.addFlashAttribute("flashAttr", "flashAttrVal");
            return "redirect:/test2/{id}";
        }
    }

    @RequestMapping("test2/{id}")
    public String handleRequest (@PathVariable("id") String id,
                                 @RequestParam("attr") String attr,
                                 @ModelAttribute("flashAttr") String flashAttr,
                                 Model model) {

        model.addAttribute("id", id);
        model.addAttribute("attr", attr);
        model.addAttribute("flashAttr", flashAttr+"");
        return "my-page";
    }
}
