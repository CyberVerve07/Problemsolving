package august.augest4.Practice;

import java.io.Serializable;

public class Sbi implements Serializable {

    private  String accountHolderName;
    private  String accountId;
    private  double balance;
    private  String address;
    private  String  IfscCode;


    //Generat the Constructor


    public Sbi(String accountHolderName, String accountId, double balance, String address, String ifscCode) {
        this.accountHolderName = accountHolderName;
        this.accountId = accountId;
        this.balance = balance;
        this.address = address;
        IfscCode = ifscCode;
    }

    //Generate Getters and Setters ::


    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIfscCode() {
        return IfscCode;
    }

    public void setIfscCode(String ifscCode) {
        IfscCode = ifscCode;
    }

    //Method name is Se


}
