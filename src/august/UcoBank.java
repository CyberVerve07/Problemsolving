package august;

import java.io.Serializable;

public class UcoBank implements Serializable {
    private  String userName;
    private  String branch;
    private String address;
    private String city;
    private  transient double balance;


    public UcoBank(String userName, String branch, String address, String city, double balance) {
        this.userName = userName;
        this.branch = branch;
        this.address = address;
        this.city = city;
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public String getBranch() {
        return branch;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public double getBalance() {
        return balance;
    }
}
