package com.example.demo;

import Project.Product;

import java.util.List;
import java.util.Map;

//helper class for the ProductController GetMapping so it's organized as the way you see it
public class CustomResponse {
    private List<Product> products;
    private Map<String, Integer> categories;

    public CustomResponse(List<Product> products, Map<String, Integer> categories) {
        this.products = products;
        this.categories = categories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Map<String, Integer> getCategories() {
        return categories;
    }
}
