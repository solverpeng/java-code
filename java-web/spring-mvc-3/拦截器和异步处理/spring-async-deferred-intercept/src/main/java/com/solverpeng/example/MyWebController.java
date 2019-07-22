package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

@Controller
public class MyWebController {
    @RequestMapping("/")
    @ResponseBody
    public DeferredResult<String> handleTestRequest () {

        System.out.println("controller#handler called. Thread: " +
                Thread.currentThread()
                        .getName());

        final DeferredResult<String> deferredResult = new DeferredResult<>();

        new Thread(() -> {
            System.out.println("controller-deferred#async task started. Thread: " +
                    Thread.currentThread()
                            .getName());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            deferredResult.setResult("test async result");
            System.out.println("controller-deferred#async task finished");
        }).start();


        System.out.println("controller#handler finished");
        return deferredResult;
    }
}
