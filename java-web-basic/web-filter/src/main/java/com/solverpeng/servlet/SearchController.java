package com.solverpeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "searchController", urlPatterns = "/search/*")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //we are going to pause for a while
            // to simulate the expensive search process
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PrintWriter writer = resp.getWriter();
        writer.println("Test Search Result");
    }
}
