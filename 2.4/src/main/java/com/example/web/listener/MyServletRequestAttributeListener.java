package com.example.web.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Created by kslisenko on 11/23/14.
 */
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("Attribute added " + servletRequestAttributeEvent.getName() + "=" + servletRequestAttributeEvent.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("Attribute removed " + servletRequestAttributeEvent.getName() + "=" + servletRequestAttributeEvent.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("Attribute replaced " + servletRequestAttributeEvent.getName() + "=" + servletRequestAttributeEvent.getValue());
    }
}
