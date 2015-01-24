package com.example.web.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kslisenko on 11/21/14.
 */
public class ProductDao {

    Map<Integer, Product> data = new HashMap<>();

    public ProductDao() {
        data.put(1, new Product(1, "Motorola C155", 150, false));
        data.put(2, new Product(2, "Huawei U8800", 250, true));
        data.put(3, new Product(3, "Audi A6", 30000, false));
        data.put(4, new Product(4, "Peace of bred", 0.99, false));
        data.put(5, new Product(5, "Coca-Cola", 0.65, true));
    }

    public List<Product> getAll() {
        return new ArrayList<>(data.values());
    }

    public Product get(int id) {
        return data.get(id);
    }
}
