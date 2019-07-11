package com.solverpeng.example;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class UserValidator implements Validator {
    private static final Pattern EMAIL_REGEX =
            Pattern.compile("^[\\w\\d._-]+@[\\w\\d.-]+\\.[\\w\\d]{2,6}$");

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass == User.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "user.name.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "user.password.empty");
        ValidationUtils.rejectIfEmpty(errors, "email", "user.email.empty");

        User user = (User) target;
        if (user.getName() != null && user.getName().length() < 5 ||
                user.getName().length() > 20) {
            errors.rejectValue("name", "user.name.size");
        }

        if (user.getPassword() != null && user.getPassword().contains(" ")) {
            errors.rejectValue("password", "user.password.space");
        }

        if (user.getPassword() != null && (user.getPassword().length() < 5 ||
                user.getPassword().length() > 15)) {
            errors.rejectValue("password", "user.password.size");
        }

        if (user.getEmail() != null && !EMAIL_REGEX.matcher(user.getEmail()).matches()) {
            errors.rejectValue("email", "user.email.invalid");
        }
    }
}
