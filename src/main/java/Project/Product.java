package Project;

import java.security.PrivateKey;

//Product class definition nothing but setters and getters
public class Product {
    //if any operations are needed on the Price make sure to cast it as an Int before any operations
    private String Name, Vendor, Category, SerialNumber;
    double Price;

    public Product(double price, String name, String vendor, String category, String serialNumber) {
        Price = price;
        Name = name;
        Vendor = vendor;
        Category = category;
        SerialNumber = serialNumber;
    }

    public Product() {

    }
    //Setters//
    public void setPrice(double price) {
        Price = price;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setVendor(String vendor) {
        Vendor = vendor;
    }
    public void setCategory(String category) {
        Category = category;
    }
    public void setSerialNumber(String serialNumber) {
        SerialNumber = serialNumber;
    }
    //Getters//
    public double getPrice() {
        return Price;
    }
    public String getName() {
        return Name;
    }
    public String getVendor() {
        return Vendor;
    }
    public String getCategory() {
        return Category;
    }
    public String getSerialNumber() {
        return SerialNumber;
    }
}
