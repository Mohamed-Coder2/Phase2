package Project;

import java.util.ArrayList;
import java.util.List;

public class CompoundOrders implements Order {
    private int orderID;
    private OrderStatus orderStatus;
    private List<Customer> customers;
    private List<Product> products;

    public CompoundOrders(int orderID, List<Customer> customers, List<Product> products) {
        this.orderID = orderID;
        this.customers = customers;
        this.products = products;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public int getOrderID() {
        return orderID;
    }
    @Override
    public List<Customer> getCustomers() {
        return customers;
    }
    @Override
    public List<Product> getProducts() {
        return products;
    }
    @Override
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
