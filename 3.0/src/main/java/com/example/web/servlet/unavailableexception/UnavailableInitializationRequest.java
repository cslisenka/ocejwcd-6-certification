package com.example.web.servlet.unavailableexception;

import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/unavailableRequest")
public class UnavailableInitializationRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String timeout = req.getParameter("timeout");
        if (timeout != null) {
            System.out.println("UnavailableInitializationRequest doGet() with timeout");
            throw new UnavailableException("Unavailable in request", Integer.parseInt(timeout));
        } else {
            System.out.println("UnavailableInitializationRequest doGet()");
            throw new UnavailableException("Unavailable in request");
        }
    }
}
