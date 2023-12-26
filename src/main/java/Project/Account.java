package Project;

public class Account {
    private String username, password, Email;
    private double balance;
    private shoppingCart Cart;

    public shoppingCart getCart() {
        return Cart;
    }

    public void setCart(shoppingCart cart) {
        Cart = cart;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String passWord) {
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
