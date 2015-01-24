package com.example.web.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class HasRoleTagHandler extends SimpleTagSupport {

    public HasRoleTagHandler() {
        System.out.println(getClass().getName() + "()");
    }

    private String role;
    private boolean anonymous;

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println(getClass().getName() + " doTag()");

        PageContext pageContext = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        if (!anonymous) {
            if ((role == null && request.getUserPrincipal() != null) ||
                    (role != null && request.isUserInRole(role))) {
                getJspContext().setAttribute("userName", request.getRemoteUser());
                getJspBody().invoke(null);
            }
        } else if (request.getUserPrincipal() == null) {
            getJspBody().invoke(null);
        }
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }
}