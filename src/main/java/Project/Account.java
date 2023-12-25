package Project;

public class Account {
    private String userName, passWord, EMail;
    private double balance;
    private shoppingCart Cart;

    public shoppingCart getCart() {
        return Cart;
    }

    public void setCart(shoppingCart cart) {
        Cart = cart;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEMail() {
        return EMail;
    }

    public void setEMail(String EMail) {
        this.EMail = EMail;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
