package Controllers;


import Project.Customer;
import Project.Product;

import java.util.ArrayList;
//Utility class used for the PostMapping in OrderController class
public class OrderPayload {
    private ArrayList<Integer> customerID;
    private ArrayList<Integer> products;


    public ArrayList<Integer> getCustomerID() {
        return customerID;
    }

    public void setCustomerID(ArrayList<Integer> customerID) {
        this.customerID = customerID;
    }

    public ArrayList<Integer> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Integer> products) {
        this.products = products;
    }
}

