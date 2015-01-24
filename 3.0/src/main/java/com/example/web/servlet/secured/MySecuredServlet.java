package com.example.web.servlet.secured;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ServletSecurity(
    //@HttpConstraint(transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL, rolesAllowed = "admin")
    @HttpConstraint(rolesAllowed = "admin")
)
@WebServlet("/secured")
public class MySecuredServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.println("User: " + req.getUserPrincipal());
        out.println("Secured content");
    }
}