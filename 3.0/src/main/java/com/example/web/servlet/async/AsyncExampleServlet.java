package com.example.web.servlet.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncExampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/async thread name start " + Thread.currentThread().getName());
        // TODO try forward + dispath, see http://docs.oracle.com/javaee/6/api/javax/servlet/AsyncContext.html#dispatch()
        int timeout = getTimeout(req);

        AsyncContext async = req.startAsync();
        async.setTimeout(timeout);
        async.addListener(new LoggingAsyncListener());
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//        }

        async.start(new LongTaskForAsync(10, async, req.getParameter("dispatchUrl"), isDispatch(req)));
        System.out.println("/async thread name finish " + Thread.currentThread().getName());
    }

    private int getTimeout(HttpServletRequest req) {
        String timeout = req.getParameter("timeout");
        if (timeout != null) {
            return Integer.parseInt(req.getParameter("timeout"));
        }

        return 10000;
    }

    private boolean isDispatch(HttpServletRequest req) {
        return req.getParameter("isDispatch") != null;
    }
}