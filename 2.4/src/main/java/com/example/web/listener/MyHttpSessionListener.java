package com.example.web.listener;

import com.example.web.model.ShoppingCart;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by kslisenko on 11/23/14.
 */
public class MyHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println(">>Session " + httpSessionEvent.getSession().getId() + " created!!!");
        httpSessionEvent.getSession().setAttribute("cart", new ShoppingCart());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println(">>Session " + httpSessionEvent.getSession().getId() + " destroyed!!!");
    }
}
