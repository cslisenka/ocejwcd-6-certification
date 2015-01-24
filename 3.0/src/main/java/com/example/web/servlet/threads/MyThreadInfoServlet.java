package com.example.web.servlet.threads;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/thread")
public class MyThreadInfoServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println(getClass().getName() + ".init() thread: " + Thread.currentThread().getName() + " id:" + Thread.currentThread().getId());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println(getClass().getName() + " thread: " + Thread.currentThread().getName() + " id:" + Thread.currentThread().getId());
        printSessionAttributeWithSleep(req.getSession(), "myattr", out, req.getParameter("sync") != null);
    }

    protected void printSessionAttributeWithSleep(HttpSession session, String name, PrintWriter out, boolean isSynchronize) {
        if (isSynchronize) {
            synchronized (session) {
                out.println("Synchronized access to session");
                printSessionAttributeWithSleep(session, name, out);
            }
        } else {
            printSessionAttributeWithSleep(session, name, out);
        }
    }

    protected void printSessionAttributeWithSleep(HttpSession session, String name, PrintWriter out) {
        out.format("Session: %s=%s \n", name, session.getAttribute(name));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        out.format("Session: %s=%s \n", name, session.getAttribute(name));
    }
}