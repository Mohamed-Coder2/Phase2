package Project;

public class Product {
    private double price;
    private String name, vendor, category, serialNumber;
    //Fill the constructor as needed
    public Product() {

    }
    public String printProduct() {
        return String.format(
                "Serial Number: %s, Price: %.2f, Product Name: %s, Vendor: %s, Category: %s",
                serialNumber, price, name, vendor, category
        );
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
