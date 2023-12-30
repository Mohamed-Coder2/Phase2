package Project;

//Each Customer has an Account which is defined here
public class Account {
    private String username, password, Email;
    private double balance; //can be defined from a third party Bank API
    private shoppingCart Cart = new shoppingCart(); //For each account you can have one cart

    public shoppingCart getCart() {
        return Cart;
    }

    public void setCart(shoppingCart cart) {
        Cart = cart;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String userName) {
        this.username = userName;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String passWord) {
        this.password = passWord;
    }

    public String getEMail() {
        return Email;
    }

    public void setEMail(String EMail) {
        this.Email = EMail;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
