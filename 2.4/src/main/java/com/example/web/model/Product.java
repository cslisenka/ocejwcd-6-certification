package com.example.web.model;

/**
 * Created by kslisenko on 11/21/14.
 */
public class Product {

    private int id;
    private String name;
    private double price;
    private boolean specialOffer;

    public Product() {
    }

    public Product(int id, String name, double price, boolean specialOffer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.specialOffer = specialOffer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(boolean specialOffer) {
        this.specialOffer = specialOffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }
}