package com.solverpeng.servlert;

import com.google.common.cache.LoadingCache;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@WebServlet(name = "appController", urlPatterns = "/app/*", loadOnStartup = 1)
public class AppController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object cache = req.getServletContext().getAttribute("GLOBAL_CACHE");
        if (cache instanceof LoadingCache) {
            try {
                resp.getWriter().println((((LoadingCache) cache).get("key")));
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("servlet loaded " + this);
    }
}
