package Project;

import java.util.ArrayList;

public class CompoundOrders implements Order {
    private int orderID;
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;

    public CompoundOrders(int orderID, ArrayList<Customer> customers, ArrayList<Product> products) {
        this.orderID = orderID;
        this.customers = customers;
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
