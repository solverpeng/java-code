package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;
import java.util.logging.Logger;

@Controller
public class MyController {
    private Logger logger = Logger.getLogger(MyController.class.getSimpleName());

    @RequestMapping("test")
    public @ResponseBody Callable<String> handleTestRequest () {
        logger.info("handler started");
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call () throws Exception {
                logger.info("async task started");
                Thread.sleep(2000);
                logger.info("async task finished");
                return "async result";
            }
        };

        logger.info("handler finished");
        return callable;
    }
}
