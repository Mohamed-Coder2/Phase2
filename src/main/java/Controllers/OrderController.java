package Controllers;

import Project.*;
import Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private int orderID = 10000;
    private Order order;
    private final OrderStatusService orderStatusService;
    @Autowired
    private final CustomerController customerController;
    @Autowired
    private final ProductController productController;
    private List<Customer> existingCustomers;
    private List<Product> existingProducts;
    List<Customer> selectedCustomers;
    private List<Order> orders = new ArrayList<>();

    // Define the delay in milliseconds (e.g., 10 seconds)
    private static final long DELAY_BEFORE_SHIPPING = 10000;

    @Autowired
    public OrderController(OrderStatusService orderStatusService, CustomerController customerController, ProductController productController) {
        this.orderStatusService = orderStatusService;
        this.productController = productController;
        this.customerController = customerController;
    }

    private List<Customer> getExistingCustomers() {
        ResponseEntity<List<Customer>> response = customerController.getAllUsers();
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            // Handle the case when the request to get customers fails
            return Collections.emptyList();
        }
    }

    private List<Product> getExistingProducts() {
        ResponseEntity<List<Product>> response = productController.getProducts();
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            // Handle the case when the request to get products fails
            return Collections.emptyList();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderPayload orderPayload) {
        // Retrieve existing customers from the customer controller
        existingCustomers = getExistingCustomers();
        // Retrieve existing products from the product controller
        existingProducts = getExistingProducts();

        if (orderPayload.getCustomerID().size() == 1) {
            // It's a simple order
            order = new SimpleOrder(orderID, existingCustomers, existingProducts);
        } else {
            // It's a compound order
            selectedCustomers = existingCustomers.stream()
                    .filter(customer -> orderPayload.getCustomerID().contains(customer.getID()))
                    .collect(Collectors.toList());

            order = new CompoundOrders(orderID, selectedCustomers, existingProducts);
        }

        // Check customer balance and update order status
        if (order instanceof SimpleOrder) {
            SimpleOrder simpleOrder = (SimpleOrder) order;
            Customer customer = existingCustomers.get(0);
            double totalOrderAmount = calculateTotalOrderAmount(order);

            if (customer.getaccount().getBalance() >= totalOrderAmount) {
                // Deduct the balance only if the order is shipped
                orderStatusService.updateOrderStatus(String.valueOf(orderID), OrderStatus.PENDING);
            } else {
                // Insufficient balance, cancel the order
                return new ResponseEntity<>("Insufficient balance. Order canceled.", HttpStatus.BAD_REQUEST);
            }
        } else if (order instanceof CompoundOrders) {
            // For each selected customer in the compound order
            CompoundOrders compoundOrder = (CompoundOrders) order;
            for (Customer selectedCustomer : compoundOrder.getCustomers()) {
                double totalOrderAmount = calculateTotalOrderAmount(order);

                if (selectedCustomer.getaccount().getBalance() >= totalOrderAmount) {
                    // Deduct the balance only if the order is shipped
                    orderStatusService.updateOrderStatus(String.valueOf(orderID), OrderStatus.PENDING);

                } else {
                    // Insufficient balance, cancel the order for the specific customer
                    // For now, I'm returning a general error message
                    return new ResponseEntity<>("Insufficient balance for one or more customers. Order canceled.", HttpStatus.BAD_REQUEST);
                }
            }
        } else {
            orderStatusService.updateOrderStatus(String.valueOf(orderID), OrderStatus.PENDING);
        }

        // Increment the order ID for the next order
        orderID++;

        orders.add(order);

        for (Customer c: selectedCustomers) {
            c.getaccount().deductBalance(calculateTotalOrderAmount(order));
        }

        return new ResponseEntity<>("Thank you " + getCustomerNamesList(selectedCustomers) + " your order with the ID: " + orderID +" created successfully", HttpStatus.CREATED);
    }

    private String getCustomerNamesList(List<Customer> customers) {
        return "{" + customers.stream()
                .map(Customer::getname)
                .collect(Collectors.joining(", ")) +
                "}";
    }


    public Order getOrderByID(int ID) {
        for (Order o:orders) {
            if(o.getOrderID() == ID){
                return o;
            }
        }
        return null;
    }

    // Scheduled task to automatically change the status from Pending to Shipped
    @Scheduled(fixedRate = DELAY_BEFORE_SHIPPING)
    public void processPendingOrders() {
        for (String orderId : orderStatusService.getPendingOrders()) {
            // Update the status to Shipped
            orderStatusService.updateOrderStatus(orderId, OrderStatus.SHIPPED);
        }
    }

    @GetMapping("/status")
    public ResponseEntity<Map<String, String>> getOrderStatus() {
        // Update the status using OrderStatusService
        Map<String, String> statusMap = orderStatusService.getAllOrderStatus();
        return new ResponseEntity<>(statusMap, HttpStatus.OK);
    }

    @PostMapping("/cancel/{orderID}")
    public ResponseEntity<String> cancelOrder(@PathVariable int orderID) {
        // Retrieve the order based on orderId
        Order cancelledOrder = getOrderByID(orderID);

        if (cancelledOrder != null) {
            // Return the deducted balance for a canceled order
            returnAmountToCustomer(order);

            // Remove the canceled order from the list
            orders.remove(cancelledOrder);

            // Update the order status to CANCELED
            orderStatusService.updateOrderStatus(String.valueOf(orderID), OrderStatus.CANCELED);

            return new ResponseEntity<>("Order: "+orderID+" canceled successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
        }
    }
    //customer.getaccout.deductBalance(calculateTotalOrderAmount(order))
    private double calculateTotalOrderAmount(Order order) {
        // Calculate the total order amount based on the products in the order
        double amount = 0.0;
        for (Product p : order.getProducts()) {
            amount += p.getPrice();
        }

        return amount;
    }

    private void returnAmountToCustomer(Order order) {
        // Implement the logic to return the amount to the customer for a canceled order
        double totalOrderAmount = calculateTotalOrderAmount(order);

        for (Customer c: selectedCustomers) {
            c.getaccount().addBalance(calculateTotalOrderAmount(order));
        }
    }
}
