package com.example.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kslisenko on 27.11.14.
 */
public class CookieManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/includes/header.jsp").include(req, resp);
        PrintWriter out = resp.getWriter();

        String action = req.getParameter("action");
        if ("add".equals(action)) {
            Cookie newCookie = new Cookie(req.getParameter("name"), req.getParameter("value"));
            newCookie.setMaxAge(Integer.parseInt(req.getParameter("maxage")));
            newCookie.setPath(req.getParameter("path"));
            resp.addCookie(newCookie);
        }

        out.print("<html><body><h2>Cookie management</h2>");
        title(out, "Cookies");
        tableHeader(out, "Name", "Value", "Domain", "Comment", "Path", "MaxAge", "Secure", "Version");
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                row(out, cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getComment(),
                        cookie.getPath(), cookie.getMaxAge() + "", cookie.getSecure() + "", cookie.getVersion() + "");
            }
            tableFooter(out);
        }

        out.print("<h3>Set cookie</h3>");
        out.print("<form>Name: <input type='text' name='name'/><br>" +
                "Value: <input type='text' name='value'/><br>" +
                "Max age: <input type='text' name='maxage'/><br>" +
                "Path: <input type='text' name='path'/><br>" +
                "<input type='submit' value='Set cookie!'/>" +
                "<input type='hidden' name='action' value='add'/></form>");
        out.print("<br><a href='/ocjwp1/admin/cookie'>Reload</a>");
        getServletContext().getRequestDispatcher("/WEB-INF/includes/footer.jsp").include(req, resp);
    }

    protected void row(PrintWriter out, String... value) {
        out.println("<tr>");
        for (String v : value) {
            out.print("<td>" + v + "</td>");
        }
        out.println("</tr>");
    }

    protected void headerRow(PrintWriter out, String... value) {
        out.println("<tr>");
        for (String v : value) {
            out.print("<td><b>" + v + "</b></td>");
        }
        out.println("</tr>");
    }

    protected void tableHeader(PrintWriter out, String... value) {
        out.println("<table border='1'>");
        headerRow(out, value);
    }

    protected void tableFooter(PrintWriter out) {
        out.println("</table>");
    }

    protected void title(PrintWriter out, String value) {
        out.println("<h2>" + value + "</h2>");
    }

}