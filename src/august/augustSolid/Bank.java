package august.augustSolid;

public class Bank {

    //Create the user in bank
     private  String name;
     private  String accountId;
     private  String address;
     private String  phoneNo;
     private  String branch;
     private  double balance;
     private String city;
     private  double ifsceCode;


     //Create the Constructor for it :


    public Bank(String name, String accountId, String address, String phoneNo, String branch, double balance, String city, double ifsceCode) {
        this.name = name;
        this.accountId = accountId;
        this.address = address;
        this.phoneNo = phoneNo;
        this.branch = branch;
        this.balance = balance;
        this.city = city;
        this.ifsceCode = ifsceCode;
    }

    //Generate the Getter and setters method :


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getIfsceCode() {
        return ifsceCode;
    }

    public void setIfsceCode(double ifsceCode) {
        this.ifsceCode = ifsceCode;
    }

}
