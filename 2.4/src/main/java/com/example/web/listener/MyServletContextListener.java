package com.example.web.listener;

import com.example.web.model.ProductDao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by kslisenko on 11/23/14.
 */
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(">>>>Context created! source: " + servletContextEvent.getSource());
        servletContextEvent.getServletContext().setAttribute("db", new ProductDao());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(">>>>Context destroyed!");
    }
}
