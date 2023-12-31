package Controllers;

import Project.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {
        int orderID = orderRequest.getOrderID();
        ArrayList<Customer> customers = orderRequest.getCustomerIDs();
        ArrayList<Product> products = orderRequest.getProducts();

        Order order;
        if (customers.size() == 1) {
            order = new SimpleOrder(orderID, customers.get(0), products);
        } else {
            order = new CompoundOrders(orderID, customers, products);
        }

        // Process the order as needed (store in a database, send notifications, etc.)

        return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
    }
}

