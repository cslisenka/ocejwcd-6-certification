package com.example.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;

/**
 * Created by kslisenko on 11/23/14.
 */
public class MyServletContextAttributeListener implements javax.servlet.ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        ServletContext context = servletContextAttributeEvent.getServletContext();
        System.out.println(">>>>Attribute added '" + servletContextAttributeEvent.getName() + "', value = '" + servletContextAttributeEvent.getValue() + "'");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        ServletContext context = servletContextAttributeEvent.getServletContext();
        System.out.println(">>>>Attribute removed '" + servletContextAttributeEvent.getName() + "', value = '" + servletContextAttributeEvent.getValue() + "'");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        ServletContext context = servletContextAttributeEvent.getServletContext();
        System.out.println(">>>>Attribute replaced '" + servletContextAttributeEvent.getName() + "', value = '" + servletContextAttributeEvent.getValue() + "'");
    }
}
