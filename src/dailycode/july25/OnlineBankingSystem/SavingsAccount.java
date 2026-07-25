package dailycode.july25.OnlineBankingSystem;

public class SavingsAccount extends AccountManagement {

    public SavingsAccount(String accountHolderName,
                          String accountNumber,
                          double balance) {

        super(accountHolderName, accountNumber, balance);


    }

    @Override
    void withdrawal(double amount) {

        if (amount <= getBalance()) {

            setBalance(getBalance() - amount);

            System.out.println("Withdrawal Successful");
            System.out.println("Remaining Balance : ₹" + getBalance());

        } else {

            System.out.println("Insufficient Balance");

        }

    }




    @Override
     String accountType() {
        return "Saving Account";
    }

    @Override
    double CalcIntrest(double intrest) {
      intrest=  getBalance()*7.5/100;
        return 0;
    }

}