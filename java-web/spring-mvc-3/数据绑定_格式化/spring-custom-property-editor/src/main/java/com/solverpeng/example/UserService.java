package com.solverpeng.example;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    List<User> getAllUsers();
}
