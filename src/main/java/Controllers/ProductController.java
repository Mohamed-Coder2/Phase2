package Controllers;

import Project.Product;
import Project.ProductsManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Object> getAllProducts() {
        List<Product> productList = productsManager.getProducts();
        Map<String, Integer> categoryCount = productsManager.getCategoryCount();

        CustomResponse customResponse = new CustomResponse(productList, categoryCount);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }
}




