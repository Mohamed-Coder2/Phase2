package Project;

import java.util.List;

public interface Order {
    int getOrderID();
    List<Customer> getCustomers();
    List<Product> getProducts();
    OrderStatus getOrderStatus();
}
