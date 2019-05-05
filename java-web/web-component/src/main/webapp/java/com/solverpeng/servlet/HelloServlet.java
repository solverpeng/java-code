package com.solverpeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;

public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("com.solverpeng.servlet.HelloServlet init!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("com.solverpeng.servlet.HelloServlet hello world!");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("com.solverpeng.servlet.HelloServlet destroy!");
    }
}
