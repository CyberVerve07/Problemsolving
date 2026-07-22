package dailycode.july22.PaymentGateway;

public class CreditCard  extends PaymentGateway implements Payment{
    public CreditCard(double balance) {
        super();
    }

    public CreditCard(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    @Override
    void pay() {
        System.out.println("Payment is Done by Using Credit card : ");

    }

}
