package com.example.web.servlet.async;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import java.io.IOException;

public class LoggingAsyncListener implements AsyncListener {

    @Override
    public void onComplete(AsyncEvent asyncEvent) throws IOException {
        System.out.println("onComplete");
    }

    @Override
    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        System.out.println("onTimeout");
    }

    @Override
    public void onError(AsyncEvent asyncEvent) throws IOException {
        System.out.println("onError");
    }

    @Override
    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
        System.out.println("onStartAsync");
    }
}
