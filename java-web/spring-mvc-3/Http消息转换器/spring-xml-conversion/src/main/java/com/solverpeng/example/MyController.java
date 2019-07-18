package com.solverpeng.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/message")
public class MyController {

    @GetMapping("/check")
    @ResponseBody
    public String check() {
        return "success";
    }

    @RequestMapping(value = "/register",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_XML_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void handleXMLPostRequest(@RequestBody User user) {
        System.out.println(user);
    }


    @RequestMapping(value = "/userList",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public UserList handleAllUserRequest() {
        UserList userList = new UserList();

        User user = new User();
        user.setId(1L);
        user.setName("tom");
        user.setEmailAddress("tom@abc.com");
        user.setPassword("tom123456");

        User user1 = new User();
        user1.setId(2L);
        user1.setName("jerry");
        user1.setEmailAddress("jerry@abc.com");
        user1.setPassword("jerry123456");

        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        userList.setUsers(users);

        return userList;
    }
}
