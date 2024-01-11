package Project;

import java.util.List;

//Customer class definition no methods here excepts setters and getters
public class Customer {
    private Account account;
    private int ID;
    private String name;

    public Customer() {

    }

    public Customer(Account account, int ID, String name) {
        this.account = account;
        this.ID = ID;
        this.name = name;
    }

    //Setters
    //Methods aren't camel cased cause spring boot has an issue where it doesn't post correctly since it doesn't "see it"
    //I'll look further but now's not the time.
    public void setaccount(Account account) {
        this.account = account;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    //Getters
    public Account getaccount() {
        return account;
    }
    public int getID() {
        return ID;
    }
    public String getname() {
        return name;
    }
}
