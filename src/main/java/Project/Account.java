package Project;

//Each Customer has an Account which is defined here
public class Account {
    private String username, password, Email;
    private double balance; //can be defined from a third party Bank API
    private ShoppingCart Cart = new ShoppingCart(); //For each account you can have one cart

    public Account(String username, String password, String email, double balance) {
        this.username = username;
        this.password = password;
        Email = email;
        this.balance = balance;
        Cart = new ShoppingCart();
    }

    public Account() {
    }
    public void deductBalance(double x){
        balance -= x;
    }
    public void addBalance(double x){
        balance += x;
    }
    //Setters//
    public void setusername(String userName) {
        this.username = userName;
    }
    public void setCart(ShoppingCart cart) {
        Cart = cart;
    }
    public void setpassword(String passWord) {
        this.password = passWord;
    }

    public void setEMail(String EMail) {
        this.Email = EMail;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    //Getters//
    public ShoppingCart getCart() {
        return Cart;
    }
    public String getusername() {
        return username;
    }
    public String getpassword() {
        return password;
    }
    public String getEMail() {
        return Email;
    }
    public double getBalance() {
        return balance;
    }
}
