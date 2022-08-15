package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return this.list;
    }

    public Product getProductById(Integer id) {
        return list.get(id);
    }

    public void addProduct(Product s) {
        list.add(s);
    }

    public void updateProduct(Product s) {
        list.set(s.getId().intValue(), s);
    }

    public void removeProduct(Product s) {
        list.remove(s.getId().intValue());
    }

    public void addList(List<Product> listOfProducts) {
        list.addAll(listOfProducts);
    }
}
