package dailycode.july16.SbiBank;

public class Account {
     private  String accountName;
      private String accountNumber;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
          if (accountName!=null){
        this.accountName = accountName;}
           else {
              System.out.println("Please Enter the name : ");
          }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
          if (accountNumber!=null) {
              this.accountNumber = accountNumber;
          }
           else {
              System.out.println(" Account number must be enter: ");
          }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
           if (balance<=0) {
               this.balance = balance;
           }else {
               System.out.println("Balance should be More the Zero: ");
           }
    }

    private  double balance;

    public Account(String accountName, String accountNumber, double balance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

       void calcResult(){
           System.out.println(" Interst is Calcuating: ");
       }
}
