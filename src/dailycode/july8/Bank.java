package dailycode.july8;

public class Bank {

    //Question 2: Bank Account
    //
    //Create a BankAccount class using encapsulation.
    //
    //Private Variables:
    //- accountHolder
    //- balance
    //
    //Methods:
    //- deposit(double amount)
    //- withdraw(double amount)
    //- getBalance()
    //
    //Conditions:
    //- Deposit amount > 0
    //- Withdraw amount <= balance
    //- Balance should never become negative.
    //*/

        private  String accountHolderName;
        private  double balance;

        //Methods

     void deposite(double amount ) {
         if (amount > 0) {
             System.out.println("Balance will be update:::::______" + balance);
             balance = amount + balance;
         } else {
             System.out.println("Deposited fail:");
         }
     }

       void withdraw(double  amount) {

           if (amount >= balance) {
               System.out.println("Withdraw is Sucessfull:::");
               balance = balance-amount;
               System.out.println("Amount is debit from account " + balance);
               System.out.println("Updated Balance is " + balance);
           } else {
               System.out.println("Withdraw is failed ");
           }
       }


    void checkBalance(double balance) {
        System.out.println("Balance is " + balance);
    }


    //Set Getters and setters for name:
    public String getAccountHolderName( String accountHolderName) {


        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }
    // set for balance


    public double getBalance() {

        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
