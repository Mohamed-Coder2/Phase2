package com.example.demo;

import Project.Product;
import Project.ProductsManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// ProductController
// Handles the Post and Get for the Products, can Add one product at a time
// but gets them all at once
@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductsManager productsManager;

    public ProductController(ProductsManager productsManager) {
        this.productsManager = productsManager;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        List<Product> currentProducts = productsManager.getProducts();
        currentProducts.add(product);

        productsManager.updateCategoryCount();

        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productsManager.getProducts(), HttpStatus.OK);
    }
}

