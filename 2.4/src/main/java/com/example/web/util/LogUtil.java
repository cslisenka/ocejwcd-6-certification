package com.example.web.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Created by kslisenko on 26.11.14.
 */
public class LogUtil {

    public static String printRequest(HttpServletRequest req) {
        Enumeration reqParams = req.getParameterNames();
        StringBuilder result = new StringBuilder();
        result.append("Params: [");
        while (reqParams.hasMoreElements()) {
            String param = reqParams.nextElement().toString();
            result.append("'" + param + "'='" + Arrays.toString(req.getParameterValues(param)) + "'");

        }
        result.append("] ");

        Enumeration reqAttrs = req.getAttributeNames();
        result.append("Attributes: [");
        while (reqAttrs.hasMoreElements()) {
            String param = reqAttrs.nextElement().toString();
            result.append("'" + param + "'='" + req.getAttribute(param) + "'");
        }
        result.append("]");

        return "Request to " + req.getRequestURI() + " " + result.toString();
    }
}
