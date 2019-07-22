package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ExampleController {
    @RequestMapping("/admin")
    @ResponseBody
    public String handleRequest (HttpServletRequest request)
            throws UserNotLoggedInException {

        Object user = request.getSession()
                .getAttribute("user");
        if (user == null) {
            throw new UserNotLoggedInException("user: " + user);
        }
        return "test response " + user;
    }

    @RequestMapping("/test")
    public void handleRequest2 () throws Exception {
        throw new Exception(new UserNotLoggedInException(null));
    }
}
