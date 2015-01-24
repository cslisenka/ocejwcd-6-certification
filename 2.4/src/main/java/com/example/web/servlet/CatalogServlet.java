package com.example.web.servlet;

import com.example.web.model.Product;
import com.example.web.model.ProductDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by kslisenko on 11/21/14.
 */
public class CatalogServlet extends HttpServlet {

    public CatalogServlet() {
        // Constructor, we should not put initialization code here
        System.out.println(CatalogServlet.class.getName() + "()");
        // We can not use log here because we get NullPointerException
//        log(CatalogServlet.class.getName() + " object created");
    }

    @Override
    public void destroy() {
        System.out.println(this.getClass().getName() + " destroy()");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        System.out.println(this.getClass().getName() + " init()");

        // Get env-entry
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            System.out.println("testEnvEntry value = " + envCtx.lookup("testEnvEntry"));
        } catch (NamingException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(this.getClass().getName() + " doGet");
        List<Product> products = ((ProductDao)getServletContext().getAttribute("db")).getAll();
        req.setAttribute("products", products);

        RequestDispatcher view = req.getRequestDispatcher("/products.jsp");
        view.forward(req, resp);
    }
}