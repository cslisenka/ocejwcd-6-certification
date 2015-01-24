package com.example.web.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateTag extends BodyTagSupport {

    public CurrentDateTag() {
        System.out.println(getClass().getName() + "()");
    }

    @Override
    public int doStartTag() throws JspException {
        System.out.println(getClass().getName() + " doStartTag()");
        pageContext.setAttribute("day", new SimpleDateFormat("dd").format(new Date()));
        pageContext.setAttribute("month", new SimpleDateFormat("MMMM").format(new Date()));
        pageContext.setAttribute("year", new SimpleDateFormat("YYYY").format(new Date()));
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        System.out.println(getClass().getName() + " doEndTag()");
        return EVAL_PAGE;
    }

    @Override
    public int doAfterBody() throws JspException {
        System.out.println(getClass().getName() + " doAfterBody()");
        return SKIP_BODY;
    }
}
