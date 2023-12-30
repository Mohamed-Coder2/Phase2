package com.example.demo;

import Project.Product;

import java.util.List;
import java.util.Map;

//helper class for the ProductController GetMapping so it's organized as the way you see it
public record CustomResponse(List<Product> products, Map<String, Integer> categories) {
}
