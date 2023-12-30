package Project;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
@Service
public class ProductsManager {
    private ArrayList<Product> products; //Our store products not the customers'
    private HashMap<String, Integer> categoryCount = new HashMap<>(); //A map that has a product category as a key and a count as the value

    //Constructor
    public ProductsManager(ArrayList<Product> products) {
        this.products = products;

        for (Product p: products) {
            categoryCount.put(p.getCategory(),
            categoryCount.getOrDefault(p.getCategory(), 0) + 1);
        }
    }

    public void updateCategoryCount() {
        categoryCount.clear(); // Clear the existing counts

        for (Product p : products) {
            categoryCount.put(p.getCategory(), categoryCount.getOrDefault(p.getCategory(), 0) + 1);
        }
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }

}
