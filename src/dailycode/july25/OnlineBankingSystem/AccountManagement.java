package dailycode.july25.OnlineBankingSystem;

      //Online Banking System – Requirements
//Create an abstract Account class.
//Support multiple account types:
//SavingsAccount
//CurrentAccount
//Every account should have:
//Account Number
//Account Holder Name
//Balance


import java.util.Scanner;

public abstract class AccountManagement {

     private String accountHolderName;
      private String accountNumber;
      private  double balance;

    public String getAccountHolderName() {
        return accountHolderName;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public AccountManagement(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance =balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    //Concrete method is Deposit and check Balance :

     void depositMoney(double amount){
        if (amount>0){
            System.out.println("Amount will be Successfully Deposited ::: ");
            balance=amount+balance;
            System.out.println("Updated  Balance is "+getBalance());
        }


     }

       void checkBalance(){
           System.out.println("Enter the  4 digit pin ::::");
           Scanner sc=new Scanner(System.in);
             int pin= sc.nextInt();

               if (pin!=1234){
                   System.out.println("Invalid pin ::::::");
               }
               else {
                   System.out.println("Your Balance is : "+getBalance());
               }


       }

         //Abstract Methods are :::::::
    //For withdrawal the money
        //Why?
    //
    //Savings Account → cannot go below minimum balance.
    //Current Account → may allow overdraft.
    //
    //So the withdrawal logic is different.
    //
    //Another abstract method:





    // Another Abstract Method :

    abstract void withdrawal(double amount);

    abstract  String accountType();
    abstract double CalcIntrest();



}
