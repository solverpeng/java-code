package com.solverpeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CharacterEncodingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        String characterEncoding = req.getCharacterEncoding();
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("get method: characterEncoding=" + characterEncoding + ", requestURL=" + requestURL);

        String name = req.getParameter("name");
        System.out.println("get method: name=" + name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        String characterEncoding = req.getCharacterEncoding();
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("post method: characterEncoding=" + characterEncoding + ", requestURL=" + requestURL);

        String name = req.getParameter("name");
        System.out.println("post method: name=" + name);
    }
}
