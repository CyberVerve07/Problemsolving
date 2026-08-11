package august.augest8;

import java.io.Serializable;

public class Demo9 implements Serializable {
    String name;
     String id;
     String address;
     private  double balance;
       String email;

        //Create Constructor


    public Demo9(String name, String id, String address, double balance, String email) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.balance = balance;
        this.email = email;
    }

      //Generate the Balance getter and settes


    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

     //Method to print the details

      void  printDetails(){
          System.out.println("User name is"+name);
          System.out.println("Address is "+address);
          System.out.println("User email is "+email);
          System.out.println("User id is "+id);
          System.out.println("Balance is "+balance);
      }



}


