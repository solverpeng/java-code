package com.solverpeng.example;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.DeferredResultProcessingInterceptor;

public class MyDeferredResultProcessingInterceptor implements DeferredResultProcessingInterceptor {
    @Override
    public <T> void beforeConcurrentHandling (NativeWebRequest request,
                                              DeferredResult<T> deferredResult)
            throws Exception {
        System.out.println("deferredInterceptor#beforeConcurrentHandler called." +
                "Thread: " + Thread.currentThread().getName());

    }

    @Override
    public <T> void preProcess (NativeWebRequest request,
                                DeferredResult<T> deferredResult) throws Exception {
        System.out.println("deferredInterceptor#preProcess called." +
                "Thread: " + Thread.currentThread().getName());

    }

    @Override
    public <T> void postProcess (NativeWebRequest request,
                                 DeferredResult<T> deferredResult,
                                 Object concurrentResult) throws Exception {
        System.out.println("deferredInterceptor#postProcess called." +
                "Thread: " + Thread.currentThread().getName());

    }

    @Override
    public <T> boolean handleTimeout (NativeWebRequest request,
                                      DeferredResult<T> deferredResult)
            throws Exception {
        System.out.println("deferredInterceptor#handleTimeout called." +
                "Thread: " + Thread.currentThread().getName());

        return false;
    }

    @Override
    public <T> void afterCompletion (NativeWebRequest request,
                                     DeferredResult<T> deferredResult)
            throws Exception {
        System.out.println("deferredInterceptor#afterCompletion called." +
                "Thread: " + Thread.currentThread().getName());

    }
}
