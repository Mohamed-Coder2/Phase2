package com.example.demo;

import Project.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// ProductController.java
@RestController
@RequestMapping("/products")
public class ProductController {

    private List<Product> products = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        products.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
