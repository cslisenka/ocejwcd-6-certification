package com.example.web.servlet.eltest;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ELTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create attributes of different scopes
        req.setAttribute("myattr", new TestBean("Request attr name"));
        req.getSession().setAttribute("myattr", new TestBean("Session attr name"));
        getServletContext().setAttribute("myattr", new TestBean("Application attr name"));

        // Create map
        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("name", "Map name");
        testMap.put("param", "Map param");
        testMap.put("param no convention", "Map param no java convention");
        req.setAttribute("testMap", testMap);

        // Create list and array
        List<String> countries = new ArrayList<>();
        countries.add("Belarus");
        countries.add("Poland");
        countries.add("Russia");
        countries.add("Ukraine");

        String[] capitals = new String[] {
            "Minsk", "Warsaw", "Moscow", "Kiev"
        };

        req.setAttribute("list", countries);
        req.setAttribute("array", capitals);

        // Set cookie
        Cookie myCoookie = new Cookie("cookieName", "cookie value");
        resp.addCookie(myCoookie);

        req.getRequestDispatcher("/eltest.jsp").forward(req, resp);
    }
}
