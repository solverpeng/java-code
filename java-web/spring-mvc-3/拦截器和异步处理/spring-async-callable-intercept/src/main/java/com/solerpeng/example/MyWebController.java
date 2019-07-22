package com.solerpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

@Controller
public class MyWebController {
    @RequestMapping("/")
    @ResponseBody
    public Callable<String> handleTestRequest () {

        System.out.println("controller#handler called." +
                "Thread: " + Thread.currentThread()
                .getName());

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call () throws Exception {
                System.out.println("controller-callable#async task started." +
                        " Thread: " + Thread.currentThread()
                        .getName());
                Thread.sleep(300);
                System.out.println("controller-callable#async task finished");
                return "async result";
            }
        };

        System.out.println("controller#handler finished");
        return callable;
    }
}
