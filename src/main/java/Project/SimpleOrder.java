package Project;

import java.util.ArrayList;
import java.util.List;

public class SimpleOrder implements Order{
    private int orderID;
    private OrderStatus orderStatus;

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    private List<Customer> customer;
    private List<Product> products;

    public SimpleOrder(int orderID, List<Customer> customer, List<Product> products) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = products;
    }

    @Override
    public int getOrderID() {
        return orderID;
    }
    @Override
    public List<Customer> getCustomers() {
        return null;
    }
    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double addShippingFees(double amount){
        return amount + 100;
    }
}
