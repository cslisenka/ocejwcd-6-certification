package com.example.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kslisenko on 11/22/14.
 */
public class ImageFileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");
        InputStream is = getServletContext().getResourceAsStream("/image.jpg");
        int read = 0;
        byte[] bytes = new byte[1024];
        OutputStream out = resp.getOutputStream();
        while ((read = is.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        out.flush();
        out.close();
        resp.setHeader("author", "kostya");
        resp.setHeader("place", "Hungary");
        resp.addHeader("place", "Budapest");
    }
}
