package Project;

import java.util.ArrayList;

//A class representing all the products for a certain customer
public class ShoppingCart {
    private ArrayList<Product> Cart = new ArrayList<>();

    public ShoppingCart() {

    }
    public void setProducts(ArrayList<Product> products) {
        this.Cart = products != null ? products : new ArrayList<>();
    }
    public ArrayList<Product> getCart() {
        return Cart;
    }
    public void AddProduct(Product p){
        Cart.add(p);
    }
    public void removeProduct(Product p){
        Cart.remove(p);
    }
}
