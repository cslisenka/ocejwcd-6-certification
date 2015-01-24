package com.example.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kslisenko on 11/30/14.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(getClass().getName() + " doGet - redirect");
        if (req.getParameter("logout") != null) {
            req.getSession().invalidate();
        }
        resp.sendRedirect("/ocjwp1/");
    }
}