package dailycode.july22.PaymentGateway;

import java.util.Scanner;

public   abstract class PaymentGateway{


    private  String accountHolderName;
    private  String   accountNumber;
    private double  balance;

    public PaymentGateway() {
        this.balance = balance;
    }

    public PaymentGateway(String accountHolderName, String accountNumber) {

        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }
//UPIPayment

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
         if (balance<0){
             System.out.println("Negative balance is not deposited"); {


             }
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
          Scanner sc=new Scanner(System.in);
           double amount= sc.nextDouble();
           balance=amount+balance;
          System.out.println();
          System.out.println("Your Account Balance after Deposite the money is "+balance);
          System.out.println("=======================================");

      }
        void  withdraw(){
         Scanner sc=new Scanner(System.in);
         double widAmount=sc.nextDouble();
          if (widAmount<=balance){
              System.out.println("You can withdrawal amount ");
              System.out.println("XXXXXXX8402 Amount is Credit from you bank Account you Available Balance is :");
              balance=widAmount-balance;
              System.out.println(balance);
          }


        }

    abstract void pay();
}
