package com.example.web.servlet;

import com.example.web.model.Product;
import com.example.web.model.ProductDao;
import com.example.web.model.ShoppingCart;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kslisenko on 25.11.14.
 */
public class ShoppingCartServlet extends HttpServlet {

    public ShoppingCartServlet() {
        System.out.println(getClass().getName() + "()");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println(getClass().getName() + " init()");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO print to log all request parameters - comma-separated
        System.out.println(getClass().getName() + " doGet");
        ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart");
        req.setAttribute("items", cart.getAll());
        req.setAttribute("total", cart.calculateTotal());
        getServletContext().getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(getClass().getName() + " doPost");
        ProductDao dao = ((ProductDao)getServletContext().getAttribute("db"));
        ShoppingCart cart = (ShoppingCart) req.getSession().getAttribute("cart");

        String operation = req.getParameter("operation");
        if ("add".equals(operation)) {
            String[] ids = req.getParameterValues("productId");
            for (String id : ids) {
                cart.addProduct(dao.get(Integer.parseInt(id)));
            }
            resp.sendRedirect("/ocjwp1/shop/catalog");
            return;
        } else if ("remove".equals(operation)) {
            String[] ids = req.getParameterValues("productId");
            for (String id : ids) {
                cart.removeProduct(dao.get(Integer.parseInt(id)));
            }
            resp.sendRedirect("/ocjwp1/shop/cart");
            return;
        } else if ("submitOrder".equals(operation)) {
            List<Product> orderItems = new ArrayList<>(cart.getAll());
            Collections.copy(orderItems, cart.getAll());
            req.setAttribute("orderItems", orderItems);
            req.setAttribute("total", cart.calculateTotal());
            cart.clear();
            getServletContext().getRequestDispatcher("/order.jsp").forward(req, resp);
            return;
        }

        doGet(req, resp);
    }
}
