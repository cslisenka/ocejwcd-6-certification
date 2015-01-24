package com.example.web.servlet.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/asyncforward", asyncSupported = true)
public class AcyncForwardExample extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Не совсем понял поведение когда делается форвард, а потом стартуется асинк
        System.out.println("AsyncForwardServlet");
        req.getRequestDispatcher("/async").forward(req, resp);
        System.out.println("/asyncforward thread name = " + Thread.currentThread().getName());
//        try {
//            Thread.sleep(5000);
//            System.out.println("/asyncforward thread name = " + Thread.currentThread().getName());
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//        }
        AsyncContext async = req.startAsync(req, resp);
        async.setTimeout(10000);
        async.addListener(new LoggingAsyncListener());
        async.start(new LongTaskForAsync(3, async, "/fileUpload.html", true));
    }
}
