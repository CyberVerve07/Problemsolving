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

        System.out.println("Payment is done by Using G.Pay ");
        System.out.println("Amount Paid: " + getBalance());






    }
}
