package Project;

public class Product {
    private int serialNumber;
    private double price;
    private String name, vendor, category;
    //Fill the constructor as needed
    public Product() {

    }
    public String PrintProduct(){
        return "Serial Number: " + serialNumber + "Price: " + price + "Product Name: " + name + "Vendor: " + vendor + "Category: " + category;
    }
    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
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
