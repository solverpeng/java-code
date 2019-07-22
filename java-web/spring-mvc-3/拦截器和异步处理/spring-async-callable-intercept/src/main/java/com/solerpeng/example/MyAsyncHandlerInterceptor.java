package com.solerpeng.example;

import org.springframework.web.context.request.async.WebAsyncManager;
import org.springframework.web.context.request.async.WebAsyncUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyAsyncHandlerInterceptor extends HandlerInterceptorAdapter {
    private static final Object CALLABLE_INTERCEPTOR_KEY = new Object();

    @Override
    public boolean preHandle (HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler) throws Exception {

        System.out.println("interceptor#preHandle called." +
                " Thread: " + Thread.currentThread()
                .getName());

        WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);
        asyncManager.registerCallableInterceptor(CALLABLE_INTERCEPTOR_KEY,
                new MyCallableProcessingInterceptor());
        return true;

    }

    @Override
    public void postHandle (HttpServletRequest request,
                            HttpServletResponse response,
                            Object handler,
                            ModelAndView modelAndView) throws Exception {

        System.out.println("interceptor#postHandle called." +
                "Thread: " + Thread.currentThread()
                .getName());
    }

    @Override
    public void afterCompletion (HttpServletRequest request,
                                 HttpServletResponse response,
                                 Object handler, Exception ex) throws Exception {
        System.out.println("interceptor#afterCompletion called Thread.: " +
                Thread.currentThread()
                        .getName());
    }

    @Override
    public void afterConcurrentHandlingStarted (HttpServletRequest request,
                                                HttpServletResponse response,
                                                Object handler) throws Exception {
        System.out.println("interceptor#afterConcurrentHandlingStarted called. " +
                "Thread: " + Thread.currentThread()
                .getName());
    }
}
