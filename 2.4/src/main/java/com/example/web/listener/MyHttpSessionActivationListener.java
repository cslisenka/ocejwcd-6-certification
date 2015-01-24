package com.example.web.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Created by kslisenko on 11/23/14.
 */
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {

    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println(">>Session " + httpSessionEvent.getSession().getId() + " will passivate");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println(">>Session " + httpSessionEvent.getSession().getId() + " did actiate");
    }
}
