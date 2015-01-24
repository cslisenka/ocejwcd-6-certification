package com.example.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet name in web.xml and in annotation do not match, so container creates 2 instances
 */
@WebServlet(urlPatterns = { "/manyinstances" }, name = "Many instances servlet different name")
public class ManyInstancesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(getClass() + ".doGet() servlet name="); // + getServletName()
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(getClass() + ".init()");
    }
}