package com.example.web.servlet;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jndiValue")
public class JNDIExampleServlet extends HttpServlet {

    @Resource(name = "jndiValue")
    private String jndiValue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Doesn't work for me. Need to clarify JNDI in future.
        PrintWriter out = resp.getWriter();
        out.println("JNDI value = " + jndiValue);
    }
}
