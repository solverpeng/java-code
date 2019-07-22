package com.solverpeng.example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public interface GreetingService {
    String getGreetingMsg();

    @Service
    @Profile("dev")
    class DevGreetingService implements GreetingService {

        @Override
        public String getGreetingMsg() {
            return "hi from dev";
        }
    }

    @Service
    @Profile("prod")
    class ProductionGreetingService implements GreetingService {

        @Override
        public String getGreetingMsg() {
            return "hi from production";
        }
    }
}
