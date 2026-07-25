package dailycode.july25.OnlineBankingSystem;

public class CurrentAccount extends AccountManagement{
    public CurrentAccount(String accountHolderName, String accountNumber, double balance) {
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
        return "Current Account";
    }

    @Override
    double CalcIntrest() {
        // Current accounts typically earn no interest
        return 0.0;
    }
}
