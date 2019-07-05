package com.solverpeng.servlet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "appServlet", urlPatterns = "/app/*")
public class AppServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        DispatcherType dispatcherType = req.getDispatcherType();
        String requestURI = req.getRequestURI();
        writer.write(String.format("response at %s, DispatcherType: %s%n", requestURI, dispatcherType));
        if (requestURI.endsWith("test")) {
            writer.println("AppServlet response at: " + requestURI);
        } else {
            int i = 10 / 0;//throwing exception
        }
    }
}
