package com.example.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kslisenko on 11/23/14.
 */
public class CommandServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/includes/header.jsp").include(req, resp);
        String to = req.getParameter("to");
        if (to != null) {
            resp.sendRedirect(to);
        }

        String status = req.getParameter("status");
        if (status != null) {
            resp.setStatus(Integer.parseInt(status));
        }

        String errorNum = req.getParameter("errorNum");
        String error = req.getParameter("error");
        if (errorNum != null) {
            if (error != null) {
                resp.sendError(Integer.parseInt(errorNum), error);
            } else {
                resp.sendError(Integer.parseInt(errorNum));
            }
        }

        String exception = req.getParameter("exception");
        if (exception != null) {
            throw new ServletException(exception);
        }

        PrintWriter out = resp.getWriter();
        out.println("Usage: to=[url to redirect]; status=[http status]; errorNum=[http error status num]&error=[tomcat error message to display]; exception=[message text] - servlet throws exception");
        getServletContext().getRequestDispatcher("/WEB-INF/includes/footer.jsp").include(req, resp);
    }
}
