package dailycode.july16.PaymentGateway;

public class Gpay extends  Payment {

    public Gpay(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        super.pay();
        System.out.println("Payment is done by using ::  Google Pay "+getAmount());
    }
}
