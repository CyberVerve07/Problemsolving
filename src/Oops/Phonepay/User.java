package oops.phonepay;

public class User {
    private String userName;
    private  double balance;

    //Getters  and setters


    public String getUserName() {
        return userName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance>0) {

            this.balance = balance;
            System.out.println("Transaction is complete ");
        } else {
            System.out.println("Yor balance is low Payment fail ");
            System.out.println("__________");

        }

    }

    public void setUserName(String userName) {
        this.userName = userName;
        //Getter setters for balance :




    }
}
