package com.solverpeng.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/register")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String handleGetRequest() {
        return "user-registration";
    }

    @PostMapping
    public String HandlePostRequest(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            populateError("name", model, bindingResult);
            populateError("email", model, bindingResult);
            populateError("password", model, bindingResult);

            return "user-registration";
        }
        userService.saveUser(user);
        return "registration-done";
    }

    private void populateError(String field, Model model, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors(field)) {
            model.addAttribute(field + "Error", Objects.requireNonNull(bindingResult.getFieldError(field)).getDefaultMessage());
        }
    }
}