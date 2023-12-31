package Controllers;

import Project.Customer;
import Project.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {
    private int orderID;
    private ArrayList<Customer> customerIDs;
    private ArrayList<Product> products;

    public OrderRequest() {
        customerIDs = new ArrayList<>();
        products = new ArrayList<>();
        orderID = 0;
    }
// Getters and setters

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public ArrayList<Customer> getCustomerIDs() {
        return customerIDs;
    }

    public void setCustomerIDs(ArrayList<Customer> customerIDs) {
        this.customerIDs = customerIDs;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
