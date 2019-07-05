package com.solverpeng.listener;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.TimeUnit;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("context initialized " + this);

        LoadingCache<String, Object> cache =
                CacheBuilder.newBuilder()
                        .maximumSize(100)
                        .expireAfterAccess(30, TimeUnit.MINUTES)
                        .build(new CacheLoader<String, Object>() {
                            @Override
                            public Object load (String s) throws Exception {
                                System.out.println("getting data for " + s);
                                /**
                                 * In real situations will get data from database
                                 * etc.
                                 */
                                return "Cached data for " + s;
                            }
                        });

        event.getServletContext()
                .setAttribute("GLOBAL_CACHE", cache);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
