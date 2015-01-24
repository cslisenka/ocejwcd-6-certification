package com.example.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(config.getInitParameter("text"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String targetPath = "/home/kslisenko/github/";
        Part part1 = req.getPart("file");
        try (
                FileOutputStream out = new FileOutputStream(new File(targetPath + part1.getName()));
                InputStream in = part1.getInputStream()
        ) {
            int read = 0;
            byte buffer[] = new byte[1024];
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        }

        resp.getWriter().println(" Content-type: " + part1.getContentType());
        resp.getWriter().println(" Name: " + part1.getName());
        resp.getWriter().println(" Size: " + part1.getSize());
        resp.getWriter().println(" Headers: ");
        for (String headerName : part1.getHeaderNames()) {
            resp.getWriter().println(" " + headerName + ": " + part1.getHeader(headerName));
        }
    }
}