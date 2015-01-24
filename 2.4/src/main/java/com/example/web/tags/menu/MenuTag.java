package com.example.web.tags.menu;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created by kslisenko on 3.12.14.
 */
public class MenuTag extends MenuItemTag {

    @Override
    public void doTag() throws JspException, IOException {
        getJspBody().invoke(null);
        outMenu(getJspContext().getOut(), items);
    }

    protected void outMenu(JspWriter out, List<MenuItem> items) throws IOException {
        out.print("<ul>");
        for (MenuItem item : items) {
            out.print("<li>");
            out.print("<a href='" + item.getUrl() + "'>" + item.getName() + "</a>");
            outMenu(out, item.getChildren());
            out.print("</li>");
        }
        out.print("</ul>");
    }
}