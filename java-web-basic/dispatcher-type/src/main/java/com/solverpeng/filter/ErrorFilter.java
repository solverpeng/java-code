package com.solverpeng.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "errorFilter", urlPatterns = "/*", dispatcherTypes = DispatcherType.ERROR)
public class ErrorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        PrintWriter writer = response.getWriter();
        writer.println("In the filter:");
        Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        writer.printf("exception: %s%n", exception);
        Integer code = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        writer.printf("status_code: %s%n", code);
        String requestUri = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        response.getWriter().printf("request_uri: %s%n", requestUri);
        response.getWriter().printf("dispatcherType: %s%n", request.getDispatcherType());
    }

    @Override
    public void destroy() {

    }
}
