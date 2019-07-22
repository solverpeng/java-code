package com.solverpeng.example;

import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

@Controller
public class MyController3 {
    @RequestMapping("/test3")
    @ResponseBody
    public WebAsyncTask<String> handleRequest (HttpServletRequest r) {
        System.out.println("asyncSupported: " + r.isAsyncSupported());
        System.out.println(Thread.currentThread().getName());

        Callable<String> callable = () -> {
            System.out.println(Thread.currentThread().getName());
            return "WebAsyncTask test";
        };

        ConcurrentTaskExecutor t = new ConcurrentTaskExecutor(
                Executors.newFixedThreadPool(1));
        return new WebAsyncTask<>(10000L, t, callable);
    }
}
