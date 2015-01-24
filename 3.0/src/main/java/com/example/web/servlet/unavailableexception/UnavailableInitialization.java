package com.example.web.servlet.unavailableexception;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/unavailableInit")
public class UnavailableInitialization extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("UnavailableInitialization init()");
        throw new UnavailableException("unavailable");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UnavailableInitialization doGet()");
        resp.getWriter().println("UnavailableInitialization");
    }

    @Override
    public void destroy() {
        System.out.println("UnavailableInitialization destroy()");
    }
}