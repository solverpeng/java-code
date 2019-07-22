package com.solverpeng.example;

public class OrderIdNotValidException extends RuntimeException  {
    public OrderIdNotValidException (String message) {
        super(message);
    }
}
