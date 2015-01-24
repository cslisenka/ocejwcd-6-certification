package com.example.web.servlet.unavailableexception;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/unavailableInitTimeout")
public class UnavailableInitializationTimeout extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("UnavailableInitializationTimeout init()");
        throw new UnavailableException("unavailable, try in 20 seconds", 20);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UnavailableInitializationTimeout doGet()");
        resp.getWriter().println("UnavailableInitializationTimeout");
    }

    @Override
    public void destroy() {
        System.out.println("UnavailableInitializationTimeout destroy()");
    }
}