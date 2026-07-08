package oops.bankaccount;

public class Main {
    public static void main(String[] args) {
        // Creating bank account details using parameterized constructor
        Details check = new Details("Aman", 123456789L, 1000.0);

        System.out.println("Account Holder Name: " + check.getName());
        System.out.println("Account Number: " + check.getAccountNumber());
        System.out.println("Initial Balance: " + check.getBalance());
        System.out.println("-------------------------------------");

        // Depositing money
        check.deposit(2000);

        // Withdrawing money
        check.withdraw(500);

        // Attempting to withdraw more than available balance
        check.withdraw(4000);
    }
}
