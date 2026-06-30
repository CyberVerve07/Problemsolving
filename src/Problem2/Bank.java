package Problem2;

public class Bank {
    private String accountHolder;
    private double balance;
    //create a constructor
    Bank(String accountHolder,double balance) {
        this.accountHolder=accountHolder;
        this.balance=balance;

    }
    // Getters setters


    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
     void deposite(double amount){
        if (balance>=0){
            balance=amount+balance;
            System.out.println("Update balance"+balance);

        }
        else {
            System.out.println("Negative Balnce not Deposite ");
        }
         }
    // Withdraw Method
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid Withdraw Amount");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Withdraw Successful");
            System.out.println("Current Balance : " + balance);
        }
    }
}






