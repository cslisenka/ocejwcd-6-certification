package com.example.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kslisenko on 11/23/14.
 */
public class ManageSessionServlet extends HttpServlet {

    public ManageSessionServlet() {
        System.out.println(getClass().getName() + "()");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println(getClass().getName() + " init()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/includes/header.jsp").include(req, resp);
        System.out.println(getClass().getName() + " doGet");
        PrintWriter out = resp.getWriter();
        out.println("<html><body><h2>Session management</h2>");

        HttpSession session = req.getSession(false);

        if (session == null) {
            out.println("No active session<br>");
        } else {
            out.println("Current active session is " + session.getId() + "<br>");
        }

        String action = req.getParameter("action");
        if ("new".equals(action)) {
            session = req.getSession();
            if (session.isNew()) {
                out.println("Created new session " + session.getId() + "<br>");
            }
        } else if ("kill".equals(action) && session != null) {
            String sesionId = req.getSession().getId();
            out.println("Killed session " + sesionId + "<br>");
            req.getSession().invalidate();
        } else if ("set".equals(action) && session != null) {
            String newValue = req.getParameter("time");
            req.getSession().setMaxInactiveInterval(Integer.parseInt(newValue));
        }

        int inactiveInterval = req.getSession(false) != null ? req.getSession().getMaxInactiveInterval() : 0;

        out.println("<form>Max inactive interval: <input type='text' name='time' value='" + inactiveInterval + "'><br><input type='submit' value='Set'/><br><input type='hidden' name='action' value='set'/></form>");

        out.println("<br><a href='" + resp.encodeURL("/ocjwp1/admin/session?action=new") + "'>Create new session</a>");
        out.println("<br><a href='/ocjwp1/admin/session?action=kill'>Kill current session</a>");

        getServletContext().getRequestDispatcher("/WEB-INF/includes/footer.jsp").include(req, resp);
    }
}