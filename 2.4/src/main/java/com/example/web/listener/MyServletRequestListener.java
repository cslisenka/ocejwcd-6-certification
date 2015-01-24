package com.example.web.listener;

import com.example.web.util.LogUtil;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by kslisenko on 11/23/14.
 */
public class MyServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest req = (HttpServletRequest) servletRequestEvent.getServletRequest();
        System.out.println("Destroyed " + LogUtil.printRequest(req));
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest req = (HttpServletRequest) servletRequestEvent.getServletRequest();
        LogUtil.printRequest(req);
        System.out.println("Initialized " + LogUtil.printRequest(req));
    }
}
