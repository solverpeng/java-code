package com.solverpeng.controller.handlermethod;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/flashAttributes")
public class FlashAttributesController {

    @GetMapping("/index")
    public String index(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("redirectAttributeKey", "redirectAttributeValue");
        redirectAttributes.addFlashAttribute("flashAttributeKey", "flashAttributeValue");
        return "redirect:/flashAttributes/get";
    }

    //
    @ResponseBody
    @GetMapping("/get")
    public String getFlashAttributes(HttpServletRequest request) {
        String redirectAttributeValue = request.getParameter("redirectAttributeKey");
        String requestFlashAttributeValue = request.getParameter("flashAttributeKey");
        Object sessionFlashAttributeValue = request.getSession().getAttribute("flashAttributeKey");
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
        return "flashAttributes->get:redirectAttributeValue=" + redirectAttributeValue + ",requestFlashAttributeValue=" +
                requestFlashAttributeValue + ",sessionFlashAttributeValue=" + sessionFlashAttributeValue + ",inputFlashMap="
                + inputFlashMap + ",outputFlashMap=" + outputFlashMap;
    }
}
