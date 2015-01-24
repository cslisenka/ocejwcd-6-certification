package com.example.web.servlet.threads;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/chvalue")
public class ChangeSessionValueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String value = req.getParameter("value");

        HttpSession session = req.getSession();

        synchronized (session) {
            if (name != null) {
                req.getSession().setAttribute(name, value);
                out.format("Set session attribute %s=%s", name, value);
            }
        }
    }
}
