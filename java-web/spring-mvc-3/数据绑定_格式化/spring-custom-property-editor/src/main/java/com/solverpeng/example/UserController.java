package com.solverpeng.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/register")
public class UserController {
    @Autowired
    private UserService userService;

    @InitBinder("user")
    public void customizeBinding(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(dateFormat, true));
    }

    @GetMapping
    public String handleGetRequest(Model model) {
        model.addAttribute("user", new User());
        return "user-registration";
    }

    @PostMapping
    public String HandlePostRequest(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "user-registration";
        }
        userService.saveUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return "registration-done";
    }
}
