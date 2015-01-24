package com.example.web.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/sesinfo")
public class MySessionInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        out.println("Session id: " + session.getId());
        out.println("Session 'username': " + session.getAttribute("username"));

        if (req.getSession().getAttribute("username") == null) {
            session.setAttribute("username", "kostya");
        }
    }
}
