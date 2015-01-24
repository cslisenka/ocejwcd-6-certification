package com.example.web.filter;

import com.example.web.filter.wrapper.MyBufferingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kslisenko on 28.11.14.
 */
public class MyForeinLinksFilter implements Filter {

    public MyForeinLinksFilter() {
        System.out.println(getClass().getName() + "()");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(getClass().getName() + " init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(getClass().getName() + " before!");
        MyBufferingResponseWrapper brw = new MyBufferingResponseWrapper((HttpServletResponse) servletResponse);

        filterChain.doFilter(servletRequest, brw);

        String result = brw.getResult();
        Pattern p = Pattern.compile("(?i)<a([^>]+)>(.+?)</a>");
        Pattern hrefP = Pattern.compile("\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))");

        List<String> foreinLinks = new ArrayList<>();

        Matcher m = p.matcher(result);
        while (m.find()) {
            Matcher hrefM = hrefP.matcher(m.group(1));
            if (hrefM.find()) {
                String link = hrefM.group(1).replaceAll("\"", "");
                if (link.contains("http://www.")) {
                    // Forein link
                    foreinLinks.add(link);
                }
            }
        }

        for (String foreinlink : foreinLinks) {
            result = result.replaceAll(foreinlink, "/ocjwp1/foreinlink?url=" + foreinlink);
        }

        servletResponse.getWriter().print(result);

        System.out.println(getClass().getName() + " after!");
    }

    @Override
    public void destroy() {
    }
}
