package com.solverpeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;

/**
 * 请求：http://localhost:8080/servlet/helloServlet?name=test
 */
public class ServletApi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.getRequestURL();// http://localhost:8080/servlet/helloServlet

        req.getRequestURI();// /servlet/helloServlet

        req.getServletPath();// /helloServlet

        String contextPath = req.getContextPath();// /servlet

        req.getServletContext();

        req.getServerName();

        req.getServerPort();

        String authType = req.getAuthType();

        Enumeration<String> headerNames = req.getHeaderNames();

        String method = req.getMethod();

        String pathInfo = req.getPathInfo();

        Cookie[] cookies = req.getCookies();

        HttpSession session = req.getSession();

        req.getRequestedSessionId();//JSESSIONID

        Collection<Part> parts = req.getParts();

        String localAddr = req.getLocalAddr();//0:0:0:0:0:0:0:1

        Locale locale = req.getLocale();

        Enumeration<Locale> locales = req.getLocales();

        String localName = req.getLocalName();

        int localPort = req.getLocalPort();//8080

        req.setAttribute("", "");

        req.getRequestDispatcher("/index.jsp").forward(req, resp);// 请求转发


    }
}
