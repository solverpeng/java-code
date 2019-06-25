package com.solverpeng.servlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "viewController", urlPatterns = {"/view/*"},
        initParams = @WebInitParam(name="renderer-class-name", value = "com.solverpeng.HtmlRenderer"),
        loadOnStartup = 1)
public class ViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String renderer = getServletConfig().getInitParameter("renderer-class-name");
        PrintWriter writer = resp.getWriter();
        writer.println("renderer:" + renderer);

        String servletName = getServletConfig().getServletName();
        writer.println("servletName:" + servletName);

    }
}
