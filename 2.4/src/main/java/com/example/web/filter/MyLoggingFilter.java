package com.example.web.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by kslisenko on 28.11.14.
 */
public class MyLoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        StringBuilder initParams = new StringBuilder();
        initParams.append("[");
        Enumeration initParameters = filterConfig.getInitParameterNames();
        while (initParameters.hasMoreElements()) {
            String initParamName = initParameters.nextElement().toString();
            initParams.append(initParamName).append("=").append(filterConfig.getInitParameter(initParamName)).append(", ");
        }
        initParams.append("]");

        System.out.println(filterConfig.getFilterName() + " Filter init " + initParams.toString());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        System.out.println(getClass().getName() + " doFilter " + req.getQueryString());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println(getClass().getName() + " destroy()");
    }
}
