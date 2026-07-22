package dailycode.july22.PaymentGateway;

public class CreditCard extends PaymentGateway implements Payment {

    public CreditCard(double balance) {
        super();
        setBalance(balance);
    }

    // Bug Fix: Now uses the fixed 3-arg constructor which actually sets the balance
    public CreditCard(String accountHolderName, String accountNumber, double balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    void pay() {
        System.out.println("---------------------------------------");
        System.out.println("Payment Method : Credit Card");
        System.out.println("Account Holder : " + getAccountHolderName());
        System.out.println("Current Balance: ₹" + getBalance());
        System.out.println("---------------------------------------");
        System.out.println("Enter the amount to pay via Credit Card:");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        double amount = sc.nextDouble();
        // ✅ Feature: balance auto-updates after Credit Card payment via processPayment
        processPayment(amount);
    }

    @Override
    public void refund() {
        System.out.println("Your Refund is Credited back to your Credit Card.");
    }
}

