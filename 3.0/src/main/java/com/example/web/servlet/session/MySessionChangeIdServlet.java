package com.example.web.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/seschangeid")
public class MySessionChangeIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("Session id: " + req.getSession().getId());
        // Since 3.1, do not understand why it doesn't work. May be tomcat has servlet 3.0 library
        req.changeSessionId();
        out.println("Session id after changes: " + req.getSession().getId());
    }
}