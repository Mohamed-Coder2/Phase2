package Project;

import java.util.ArrayList;

public class shoppingCart {
    private ArrayList<Product> Cart;

    public void AddProduct(Product p){
        Cart.add(p);
    }
    public void removeProduct(Product p){
        Cart.remove(p);
    }
    public ArrayList<Product> getProducts() {
        return Cart;
    }

    public void setCart(ArrayList<Product> cart) {
        Cart = cart;
    }
}
