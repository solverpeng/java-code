package com.solverpeng.controller.handlermethod;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/sessionAttributes")
@SessionAttributes("name")
public class SessionAttributesController {

    @RequestMapping("/add")
    public String addToSessionAttribute(Model model) {
        model.addAttribute("name", "tom");
        return "sessionAttributes->add->name:tom";
    }

    @RequestMapping("/add2")
    public String addToSessionAttribute2(Model model, HttpSession session) {
        String name = session.getAttribute("name").toString();
        model.addAttribute("name", "jerry");
        return "sessionAttributes->add2->name:jerry, name=" + name;
    }

    @RequestMapping("/clear")
    public String removeSessionAttributes(HttpSession session, SessionStatus status) {
        String name = session.getAttribute("name").toString();
        status.setComplete();
        return "sessionAttributes->clear,name=" + name;
    }

    @RequestMapping("/get")
    public String getSessionAttributes(HttpSession session) {
        Object name = session.getAttribute("name");
        return "sessionAttributes->get,name=" + (Objects.isNull(name) ? "clear" : name.toString());
    }
}
