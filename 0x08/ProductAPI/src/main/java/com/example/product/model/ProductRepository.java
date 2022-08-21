package com.example.product.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(Long id) {
       return list.stream().filter(p -> p.getId().equals(id)).findFirst().get();
    }

    public void addProduct(Product s) {
        this.list.add(s);
    }

    public void updateProduct(Product s) {
        this.list.set(list.indexOf(s), s);
    }

    public void removeProduct(Product s) {
        this.list.remove(s);
    }

    public void addList(List<Product> listOfProducts) {
        list.addAll(listOfProducts);
    }
}
