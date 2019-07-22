package com.solverpeng.example;

public class UserNotLoggedInException extends Exception {
    public UserNotLoggedInException (String message) {
        super(message);
    }
}
