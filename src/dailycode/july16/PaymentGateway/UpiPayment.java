package dailycode.july16.PaymentGateway;

public class UpiPayment  extends  Payment{

    public UpiPayment(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        super.pay();
        System.out.println(" Payment is done by using UPI :"+getAmount());

    }
}
