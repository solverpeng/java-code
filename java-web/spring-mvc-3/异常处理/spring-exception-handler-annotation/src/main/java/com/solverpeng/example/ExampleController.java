package com.solverpeng.example;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.Year;

@Controller
public class ExampleController {
    @RequestMapping("/data/{year}")
    @ResponseBody
    public String handleRequest (@PathVariable("year") int year) throws Exception {
        if (!Year.now().isAfter(Year.of(year))) {
            throw new Exception("Year is not before current year: " + year);
        }
        return "data response " + year;
    }

    @RequestMapping("/test/{id}")
    @ResponseBody
    public String handleRequest2 (@PathVariable("id") String id) {
        int i = Integer.parseInt(id);
        return "test response " + i;
    }

    @RequestMapping("/admin")
    @ResponseBody
    public String handleRequest2 (HttpServletRequest request)
            throws UserNotLoggedInException {
        Object user = request.getSession()
                .getAttribute("user");
        if (user == null) {
            throw new UserNotLoggedInException("user: " + user);
        }
        return "test response " + user;
    }

    @ExceptionHandler(NumberFormatException.class)
    public String exceptionHandler (NumberFormatException re, Model model) {
        model.addAttribute("exception", re);
        return "errorPage";
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exceptionHandler2 (Exception re, Model model) {
        System.out.println(model);
        return "Exception: " + re.getMessage();
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(UserNotLoggedInException.class)
    public String exceptionHandler3 (UserNotLoggedInException e, Model model) {
        model.addAttribute("exception", e);
        return "errorPage";
    }
}
