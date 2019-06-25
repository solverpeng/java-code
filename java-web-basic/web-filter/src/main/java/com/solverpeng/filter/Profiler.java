package com.solverpeng.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "profiler", urlPatterns = "/search/*",
        initParams = @WebInitParam(name="env", value = "dev"))
public class Profiler implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if ("dev".equals(filterConfig.getInitParameter("env"))) {
            long time = System.currentTimeMillis();
            chain.doFilter(request, response);

            time = System.currentTimeMillis() - time;
            String url = request instanceof HttpServletRequest ?
                    ((HttpServletRequest) request).getRequestURL().toString() : "N/A";

            System.out.println("Time taken for request to complete:  " + time
                    + "ms");
            System.out.println("Request url : " + url);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
