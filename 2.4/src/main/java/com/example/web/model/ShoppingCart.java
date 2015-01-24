package com.example.web.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kslisenko on 25.11.14.
 */
public class ShoppingCart implements HttpSessionBindingListener {

    List<Product> cartItems = new ArrayList<>();

    public void addProduct(Product product) {
        cartItems.add(product);
    }

    public void clear() {
        cartItems.clear();
    }

    public void removeProduct(Product product) {
        cartItems.remove(product);
    }

    public List<Product> getAll() {
        return cartItems;
    }

    public double calculateTotal() {
        double result = 0;
        for (Product p : cartItems) {
            result += p.getPrice();
        }

        return result;
    }

    public int getCount() {
        return cartItems.size();
    }

    public double getTotal() {
        return calculateTotal();
    }

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">>" + getClass().getName() + " binded to session " + httpSessionBindingEvent.getName() + "=" + httpSessionBindingEvent.getValue());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println(">>" + getClass().getName() + " unbinded from session " + httpSessionBindingEvent.getName() + "=" + httpSessionBindingEvent.getValue());
    }
}
