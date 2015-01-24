package com.example.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/setCookie")
public class CookieExamplesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("add") != null) {
            Cookie c = new Cookie(req.getParameter("name"), req.getParameter("value"));
            c.setHttpOnly(req.getParameter("httpOnly") != null);
            resp.addCookie(c);
            System.out.println("Added cookie " + c);
        }

        System.out.println("Send redirect");
        resp.sendRedirect(resp.encodeURL("cookieExamples.html"));
    }
}