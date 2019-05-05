package com.solverpeng.filter;

import javax.servlet.*;
import java.io.IOException;

public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("com.solverpeng.filter.FirstFilter init method");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("com.solverpeng.filter.FirstFilter doFilter method");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("com.solverpeng.filter.FirstFilter destroy method");
    }
}
