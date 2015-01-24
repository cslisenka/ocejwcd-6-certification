package com.example.web.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Created by kslisenko on 26.11.14.
 */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">>Session attribute added " + httpSessionBindingEvent.getName() + "=" + httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">>Session attribute removed " + httpSessionBindingEvent.getName() + "=" + httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        // TODO when do 'replaced' events appear?
        System.out.println(">>>>Session attribute replaced " + httpSessionBindingEvent.getName() + "=" + httpSessionBindingEvent.getValue());
    }
}
