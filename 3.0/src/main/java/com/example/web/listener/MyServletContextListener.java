package com.example.web.listener;

import com.example.web.filter.MyFilter;
import com.example.web.servlet.FileUploadServlet;
import com.example.web.servlet.secured.MyProgrammaticSecuredServlet;

import javax.servlet.*;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebListener;
import java.util.EnumSet;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(getClass() + " contextInitialized");
        ServletContext ctx = servletContextEvent.getServletContext();
        ServletRegistration reg = ctx.addServlet("uploadServlet", FileUploadServlet.class);
        reg.addMapping("/upload");
        reg.setInitParameter("text", "Servlet init parameter");

        FilterRegistration filterReg = ctx.addFilter("/*", MyFilter.class);
        filterReg.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
        filterReg.setInitParameter("log", "Log message in filter");

        ctx.addListener(MyRequestlistener.class);

        ServletRegistration.Dynamic securedServlet = ctx.addServlet("Programmatic Security Servlet", MyProgrammaticSecuredServlet.class);
        securedServlet.addMapping("/progsec");
        HttpConstraintElement sec = new HttpConstraintElement(ServletSecurity.TransportGuarantee.CONFIDENTIAL, new String[] { "admin" });
        ServletSecurityElement secElem = new ServletSecurityElement(sec);
        securedServlet.setServletSecurity(secElem);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}