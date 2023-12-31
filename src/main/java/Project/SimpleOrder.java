package Project;

import java.util.ArrayList;

public class SimpleOrder implements Order{
    private int orderID;
    private Customer customer;
    private ArrayList<Product> products;

    public SimpleOrder(int orderID, Customer customer, ArrayList<Product> products) {
        this.orderID = orderID;
        this.customer = customer;
        this.products = products;
    }

    @Override
    public int getOrderID() {
        return 0;
    }

    @Override
    public ArrayList<Customer> getCustomers() {
        return null;
    }

    @Override
    public ArrayList<Product> getProducts() {
        return null;
    }
}
