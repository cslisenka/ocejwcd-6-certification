package com.example.web.filter.wrapper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by kslisenko on 28.11.14.
 */
public class MyBufferingResponseWrapper extends HttpServletResponseWrapper {

    private StringWriter buffer = new StringWriter();

    public MyBufferingResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(buffer);
    }

    public String getResult() {
        return buffer.toString();
    }
}
