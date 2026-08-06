package august.augest6.CustomExcetion;

public class Bank {

    public static void withdraw(double balance, double amount) {

        // Validation 1
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0.");
        }

        // Validation 2
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }

        // Success Case
        balance = balance - amount;

        System.out.println("Withdrawal Successful");
        System.out.println("Withdraw Amount : " + amount);
        System.out.println("Remaining Balance : " + balance);
    }
}