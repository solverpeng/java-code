package com.solverpeng.example;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

@ControllerAdvice
public class PageCounterControllerAdvice {
    ConcurrentHashMap<String, LongAdder> map = new ConcurrentHashMap<>();

    @ModelAttribute
    public void handleRequest(HttpServletRequest request, Model model) {
        String requestURI = request.getRequestURI();
        map.computeIfAbsent(requestURI, key -> new LongAdder()).increment();

        model.addAttribute("counter", map.get(requestURI).sum());
        model.addAttribute("uri", requestURI);

    }
}
