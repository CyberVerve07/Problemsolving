package august.augest8;

import java.io.Serializable;

public class UcoBank implements Serializable {
    private  String  userName;
    private  String userAccountNumber;
    private  String address;
    private  double balance;
    private  String email;
    private  String ifcCode;

      //Generate the Constructor :


    public UcoBank(String userName, String userAccountNumber, String address, double balance, String email, String ifcCode) {
        this.userName = userName;
        this.userAccountNumber = userAccountNumber;
        this.address = address;
        this.balance = balance;
        this.email = email;
        this.ifcCode = ifcCode;
    }

    //Getter and setters


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccountNumber() {
        return userAccountNumber;
    }

    public void setUserAccountNumber(String userAccountNumber) {
        this.userAccountNumber = userAccountNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIfcCode() {
        return ifcCode;
    }

    public void setIfcCode(String ifcCode) {
        this.ifcCode = ifcCode;
    }

    public  void  getUSerDetails(){
         System.out.println("Account holder name is "+getUserName());
        System.out.println("Account number is "+getUserAccountNumber());
        System.out.println("address is"+getAddress());
        System.out.println("Balance is "+balance);
        System.out.println("email is "+getEmail());
        System.out.println("ifcs code is "+getIfcCode());
     }

}
