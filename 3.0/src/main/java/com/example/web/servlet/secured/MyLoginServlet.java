package com.example.web.servlet.secured;

import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ServletSecurity
@WebServlet("/login")
public class MyLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("HttpServletRequest.login");
        out.println("Before login. user: " + req.getRemoteUser());

        String user = req.getParameter("login");
        String password = req.getParameter("password");

        try {
            req.login(user, password);
            out.println("Login successfully " + user + "=" + password);
        } catch (ServletException e) {
            out.println("Login failed " + user + "=" + password);
            e.printStackTrace(out);
        }

        out.println("After login. User: " + req.getRemoteUser());

        if (req.getParameter("logout") != null) {
            out.println("Logout");
            req.logout();
            out.println("After logout. User: " + req.getRemoteUser());
        }
    }
}
