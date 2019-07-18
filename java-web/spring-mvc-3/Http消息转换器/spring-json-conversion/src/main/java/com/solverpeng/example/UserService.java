package com.solverpeng.example;

import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    List<User> getAllUsers();
}
