package dailycode.july22.PaymentGateway;

public class DebitCard extends PaymentGateway implements Payment {

    public DebitCard(double balance) {
        super();
        setBalance(balance);
    }

    public DebitCard(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public DebitCard(double balance, String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    void pay() {
        System.out.println("---------------------------------------");
        System.out.println("Payment Method : Debit Card");
        System.out.println("Account Holder : " + getAccountHolderName());
        System.out.println("Current Balance: ₹" + getBalance());
        System.out.println("---------------------------------------");
        System.out.println("Enter the amount to pay via Debit Card:");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        double amount = sc.nextDouble();
        //  Feature: balance auto-updates after Debit Card payment via processPayment
        processPayment(amount);
    }

    @Override
    public void refund() {
        System.out.println("Your Refund is Credited back to your Debit Card.");
    }
}

