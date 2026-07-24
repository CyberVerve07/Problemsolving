package dailycode.july23;

public class Creditcard  extends PaymentProcess implements Payment{
    @Override
    void done() {
        System.out.println("Payment is done by using the Credit Card : ");
    }

    @Override
    public void refund() {
        Payment.super.refund();
    }
}
