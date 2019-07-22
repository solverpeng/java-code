package com.solverpeng.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserNotLoggedInException extends Exception {
    public UserNotLoggedInException (String message) {
        super(message);
    }
}
