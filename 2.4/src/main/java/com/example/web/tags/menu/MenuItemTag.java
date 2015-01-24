package com.example.web.tags.menu;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kslisenko on 3.12.14.
 */
public class MenuItemTag extends SimpleTagSupport {

    protected List<MenuItem> items = new ArrayList<>();
    private String name;
    private String url;

    @Override
    public void doTag() throws JspException, IOException {
        MenuItemTag parent = (MenuItemTag) findAncestorWithClass(this, MenuItemTag.class);

        // TODO encode URL
//        PageContext context = (PageContext) getJspContext();

        JspFragment body = getJspBody();
        if (body != null) {
            body.invoke(new StringWriter());
        }

        parent.addItem(new MenuItem(name, url, items));
    }

    public void addItem(MenuItem item) {
        System.out.println("Added " + item.getName());
        items.add(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
