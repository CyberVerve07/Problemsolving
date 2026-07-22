package dailycode.july22.PaymentGateway;

import java.util.Scanner;

public   abstract class PaymentGateway{


    private  String accountHolderName;
    private  String   accountNumber;
    private double  balance;

    public PaymentGateway() {
        this.balance = 0.0;
    }

    public PaymentGateway(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public PaymentGateway(String accountHolderName, String accountNumber, double balance) {

    }
//UPIPayment

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Negative balance is not allowed");
            return;
        }
        this.balance = balance;
    }


    public String getAccountHolderName() {
        return accountHolderName;
    }
//Condition for AccountHolder Name
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

      //Methods for Deposit money and Withdraw money

      void  deposit(){
          System.out.println("Enter the Amount ");
          Scanner sc=new Scanner(System.in);
           double amount= sc.nextDouble();
           balance=amount+balance;
          System.out.println("Your Account Balance after Deposit the money is "+balance);
          System.out.println("=======================================");

      }
        double  withdraw(){
            System.out.println("Enter the  Amount");
         Scanner sc=new Scanner(System.in);
         double widAmount=sc.nextDouble();
          if (widAmount <= balance) {
              System.out.println("You can withdrawal amount ");
              System.out.println("XXXXXXX8402 Amount is Debited from your bank Account. Available Balance is :");
              balance = balance - widAmount;
              System.out.println(balance);
          } else {
              System.out.println("Insufficient balance! Withdrawal not allowed.");
          }


            return widAmount;
        }

     abstract void pay();

}
