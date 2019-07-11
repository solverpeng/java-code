package com.solverpeng.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String handleGetRequest() {
        return "user-registration";
    }

    @PostMapping
    public String handlePostRequest(User user, Model model) {
        userService.saveUser(user);
        return "registration-done";
    }

}
