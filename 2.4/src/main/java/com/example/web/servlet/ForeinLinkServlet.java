package com.example.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kslisenko on 28.11.14.
 */
public class ForeinLinkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        out.print("<html><body>");
        out.print("<h2>Are you sure want to leave this web-site?</h2>");
        out.print("We know that you want to go " + req.getParameter("url"));
        out.print("<a href='" + req.getParameter("url") + "'>Yes</a> <a href='/ocjwp1/'>No, please return me back</a>");

        out.print("</body></html>");
    }
}
