package Project;

import java.util.ArrayList;

public interface Order {
    int getOrderID();
    ArrayList<Customer> getCustomers();
    ArrayList<Product> getProducts();
}
