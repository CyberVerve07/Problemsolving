package dailycode.july22.PaymentGateway;

public class NetBanking  extends  PaymentGateway implements Payment{
    public NetBanking(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    @Override
    void pay() {
        System.out.println("Payment is done by using  NetBanking : ");

    }

    @Override
    public void Refund() {
        Payment.super.Refund();
    }
}
