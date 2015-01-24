package com.example.web.servlet.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SecurityRoleMappingServletExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Security role mapping example");
        out.println("User principal " + req.getUserPrincipal());

        if (req.isUserInRole("supervisor")) {
            out.println("supervisor (customer)");
        }

        if (req.isUserInRole("customer")) {
            out.println("customer");
        }

        if (req.isUserInRole("boss")) {
            out.println("boss (admin)");
        }

        if (req.isUserInRole("admin")) {
            out.println("admin");
        }
    }
}
