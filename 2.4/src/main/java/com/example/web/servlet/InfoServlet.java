package com.example.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by kslisenko on 11/22/14.
 */
public class InfoServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println(getClass().getName() + " init()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO we can make same functionality in JSP and use all JSP objects
        getServletContext().getRequestDispatcher("/WEB-INF/includes/header.jsp").include(req, resp);
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        header(out);

        title(out, "Request");
        tableHeader(out, "Param", "Value");
        row(out, "PathInfo", req.getPathInfo());
        row(out, "Locale", req.getLocale().toString());
        row(out, "Method", req.getMethod());
        row(out, "ContextPath", req.getContextPath());
        row(out, "AuthType", req.getAuthType());
        row(out, "PathTranslated", req.getPathTranslated());
        row(out, "QueryString", req.getQueryString());
        row(out, "RemoteUser", req.getRemoteUser());
        row(out, "RequestedSessionId", req.getRequestedSessionId());
        row(out, "RequestURI", req.getRequestURI());
        row(out, "RequestURL", req.getRequestURL().toString());
        row(out, "ServletPath", req.getServletPath());
        row(out, "CharacterEncoding", req.getCharacterEncoding());
        row(out, "ContentType", req.getContentType());
        row(out, "LocalAddr", req.getLocalAddr());
        row(out, "LocalPort", req.getLocalPort() + "");
        row(out, "RemoteHost", req.getRemoteHost());
        row(out, "RemotePort", req.getRemotePort() + "");
        row(out, "ServerPort", req.getServerPort() + "");
        row(out, "LocalName", req.getLocalName());
        row(out, "Protocol", req.getProtocol());
        row(out, "Scheme", req.getScheme());
        row(out, "UserPrincipal", req.getUserPrincipal() + "");
        row(out, "ContentLength", req.getContentLength() + "");
        tableFooter(out);

        title(out, "Headers");
        tableHeader(out, "Name", "Value");
        Enumeration headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement().toString();
            row(out, name, req.getHeader(name));
        }
        tableFooter(out);

        title(out, "Request parameters");
        tableHeader(out, "Name", "Value");
        Enumeration parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement().toString();
            row(out, name, req.getParameter(name));
        }
        tableFooter(out);

        title(out, "Cookies");
        tableHeader(out, "Name", "Value", "Domain", "Comment", "Path", "MaxAge", "Secure", "Version");
        for (Cookie cookie : req.getCookies()) {
            row(out, cookie.getName(), cookie.getValue(), cookie.getDomain(), cookie.getComment(),
                    cookie.getPath(), cookie.getMaxAge() + "", cookie.getSecure() + "",cookie.getVersion() + "");
        }
        tableFooter(out);


        title(out, "Session");
        tableHeader(out, "Param", "Value");
        row(out, "Id", req.getSession().getId());
        row(out, "CreationTime", new Date(req.getSession().getCreationTime()).toString());
        row(out, "LastAccessedTime", new Date(req.getSession().getLastAccessedTime()).toString());
        row(out, "MaxInactiveInterval", req.getSession().getMaxInactiveInterval() + "");
        row(out, "isNew", req.getSession().isNew() + "");
        tableFooter(out);

        title(out, "Session parameters");

        Enumeration sessionAttrs = req.getSession().getAttributeNames();
        tableHeader(out, "Param", "Value");
        while (sessionAttrs.hasMoreElements()) {
            String attrName = sessionAttrs.nextElement().toString();
            row(out, attrName, req.getSession().getAttribute(attrName) + "");
        }
        tableFooter(out);

        title(out, "ServletConfig");
        tableHeader(out, "Param", "Value");
        row(out, "ServletName", getServletConfig().getServletName());
        tableFooter(out);

        title(out, "ServletConfig init parameters");
        Enumeration servletConfigParams = getServletConfig().getInitParameterNames();
        tableHeader(out, "Param", "Value");
        while (servletConfigParams.hasMoreElements()) {
            String attrName = servletConfigParams.nextElement().toString();
            row(out, attrName, getServletConfig().getInitParameter(attrName));
        }
        tableFooter(out);

        title(out, "ServletContext");
        tableHeader(out, "Param", "Value");
        row(out, "MajorVersion", getServletContext().getMajorVersion() + "");
        row(out, "ServerInfo", getServletContext().getServerInfo() + "");
        row(out, "ServletContextName", getServletContext().getServletContextName());
        tableFooter(out);

        title(out, "ServletContext parameters");
        tableHeader(out, "Param", "Value");
        Enumeration initParameterNames = getServletContext().getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement().toString();
            row(out, name, getServletContext().getInitParameter(name));
        }
        tableFooter(out);

        title(out, "ServletContext attributes");
        tableHeader(out, "Param", "Value");
        Enumeration servletContextAttrs = getServletContext().getAttributeNames();
        while (servletContextAttrs.hasMoreElements()) {
            String attrName = servletContextAttrs.nextElement().toString();
            row(out, attrName, getServletContext().getAttribute(attrName) + "");
        }
        tableFooter(out);

        // Work with responce
        // Add headers
        resp.setHeader("kostya", "slisenko");
        resp.setHeader("header", "value");
        resp.addHeader("header", "value2");

        footer(out);
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

    protected void header(PrintWriter out) {
        out.println("<html><body>");
    }

    protected void footer(PrintWriter out) {
        out.println("</body></html>");
    }
}