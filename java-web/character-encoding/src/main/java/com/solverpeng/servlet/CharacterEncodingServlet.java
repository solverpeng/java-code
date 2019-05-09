package com.solverpeng.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CharacterEncodingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String characterEncoding = req.getCharacterEncoding();
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("get method: characterEncoding=" + characterEncoding + ", requestURL=" + requestURL);

        String name = req.getParameter("name");
        System.out.println("get method: name=" + name);

        //设置response以什么编码向浏览器写人
        resp.setCharacterEncoding("utf-8");
        //指定浏览器以什么编码打开
        resp.setHeader("content-type", "text/html;charset=utf-8");
        resp.getWriter().write("张三");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String characterEncoding = req.getCharacterEncoding();
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("post method: characterEncoding=" + characterEncoding + ", requestURL=" + requestURL);

        String name = req.getParameter("name");
        System.out.println("post method: name=" + name);

        //设置response以什么编码向浏览器写人
        resp.setCharacterEncoding("utf-8");
        //指定浏览器以什么编码打开
        resp.setHeader("content-type", "text/html;charset=utf-8");
        resp.getWriter().write("世界");
    }
}
