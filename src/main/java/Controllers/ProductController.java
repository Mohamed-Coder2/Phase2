package Controllers;

import Project.Product;
import Project.ProductsManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// ProductController
// Handles the Post and Get for the Products, can Add one product at a time
// but gets them all at once

/*
{
  "price": 29.99,
  "name": "Smartphone",
  "vendor": "Tech Co.",
  "category": "Electronics",
  "serialNumber": "ABC123XYZ456"
}
*/
@RestController
@RequestMapping("/products")
public class ProductController {
    ArrayList<Product> currentProducts = new ArrayList<>();

    private final ProductsManager productsManager;
    Product product1 = new Product(29.99,"Apples","FruitStore","Fruits","111112222");
    Product product2 = new Product(1699,"Iphone 14","Apple","Electronics","123456789");
    Product product3 = new Product(1450,"Jeans","H&M","Clothing","121234345");

    public ProductController() {
        currentProducts.add(product1);
        currentProducts.add(product2);
        currentProducts.add(product3);

        this.productsManager = new ProductsManager(currentProducts);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        currentProducts.add(product);

        productsManager.updateCategoryCount();

        return new ResponseEntity<>("Product " + product.getSerialNumber() + " Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllProducts() {
        List<Product> productList = productsManager.getProducts();
        Map<String, Integer> categoryCount = productsManager.getCategoryCount();

        CustomResponse customResponse = new CustomResponse(productList, categoryCount);
        return new ResponseEntity<>(customResponse, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getProducts() {
        return new ResponseEntity<>(currentProducts, HttpStatus.OK);
    }
}




