package dailycode.july22.PaymentGateway;

public class UpiPAyment extends PaymentGateway implements  Payment{


    public UpiPAyment(double balance) {
        super();
        setBalance(balance);
    }

    public UpiPAyment(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public UpiPAyment(double balance, String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
        setBalance(balance);
    }


    @Override
    void pay() {
        System.out.println("---------------------------------------");
        System.out.println("Payment Method : G-Pay (UPI)");
        System.out.println("Account Holder : " + getAccountHolderName());
        System.out.println("Current Balance: ₹" + getBalance());
        System.out.println("---------------------------------------");
        System.out.println("Enter the amount to pay via G-Pay:");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        double amount = sc.nextDouble();
        //  Feature: balance auto-updates after GPay payment via processPayment
        processPayment(amount);
    }
}
