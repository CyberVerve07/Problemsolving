package dailycode.july.day29;


import java.io.Serializable;
//To make object Serialization we a class must be implementing the Serializable :

public class Account implements Serializable {

     private  String name;
     private String acountNumber;
     private  double Balance;
      private   String location;


      //Generate Constructor


    public Account(String name, String acountNumber, double balance, String location) {
        this.name = name;
        this.acountNumber = acountNumber;
        Balance = balance;
        this.location = location;

    }
    //Generate the Geters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcountNumber() {
        return acountNumber;
    }

    public void setAcountNumber(String acountNumber) {
        this.acountNumber = acountNumber;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
//serialVersionUID is a unique long identifier used in Java for version control of Serializable classes


}
