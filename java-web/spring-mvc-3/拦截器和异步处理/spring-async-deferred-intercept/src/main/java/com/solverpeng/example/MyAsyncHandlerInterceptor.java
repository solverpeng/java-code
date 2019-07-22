package com.solverpeng.example;

import org.springframework.web.context.request.async.WebAsyncManager;
import org.springframework.web.context.request.async.WebAsyncUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyAsyncHandlerInterceptor extends HandlerInterceptorAdapter {
    private static final Object DEFERRED_INTERCEPTOR_KEY = new Object();

    @Override
    public boolean preHandle (HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler) throws Exception {

        System.out.println("interceptor#preHandle called." +
                " Thread: " + Thread.currentThread()
                .getName());

        WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);
        asyncManager.registerDeferredResultInterceptor(DEFERRED_INTERCEPTOR_KEY,
                new MyDeferredResultProcessingInterceptor());


        return true;

    }

}
