package com.solverpeng.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {
    @RequestMapping("/")
    public StreamingResponseBody handleRequest () {
        return outputStream -> {
            Map<String, BigInteger> map = new HashMap<>();
            map.put("one", BigInteger.ONE);
            map.put("ten", BigInteger.TEN);
            try(ObjectOutputStream oos = new ObjectOutputStream(outputStream)){
                oos.writeObject(map);
            }
        };
    }
}
