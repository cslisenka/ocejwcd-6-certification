package com.example.web.servlet.async;

import javax.servlet.AsyncContext;
import java.io.IOException;

/**
 * Created by kslisenko on 12/9/14.
 */
public class LongTaskForAsync implements Runnable {

    private int jobCount;
    private AsyncContext async;
    private String path;
    private boolean isDispatch;

    public LongTaskForAsync(int jobCount, AsyncContext async, String path, boolean isDispatch) {
        this.jobCount = jobCount;
        this.async = async;
        this.path = path;
        this.isDispatch = isDispatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < jobCount; i++) {
            performJob(i);
        }

        if (isDispatch) {
            if (path != null && !path.isEmpty()) {
                async.dispatch(path);
            } else {
                async.dispatch();
            }
        } else {
            async.complete();
        }
    }

    private void performJob(int i) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}

        System.out.println("Performed job " + i + " ...");

        try {
            async.getResponse().getWriter().println("Performed job " + i + " ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}