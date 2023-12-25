package Project;

public class SimpleOrder {
    private Account Customer;

    public void PrintOrder(){
        for (Product p:Customer.getCart().getProducts()) {
            System.out.println(p.PrintProduct());
        }
    }
}
