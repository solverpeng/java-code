package com.solverpeng.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class InMemoryUserService implements UserService {
    private Map<Long, User> userMap = new LinkedHashMap<>();

    @Override
    public void saveUser (User user) {
        if (user.getId() == null) {
            user.setId((long) (userMap.size() + 1));
        }
        userMap.put(user.getId(), user);

    }

    @Override
    public List<User> getAllUsers () {
        return new ArrayList<>(userMap.values());
    }
}
