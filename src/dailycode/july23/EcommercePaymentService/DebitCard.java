package dailycode.july23.EcommercePaymentService;

public class DebitCard  extends BasePayment implements Payment{
    public DebitCard(String paymentId, double amount, String customerName) {
        super(paymentId, amount, customerName);
    }

    @Override
    public void pay() {

    }

    @Override
    public void validate() {
        Payment.super.validate();
    }

    @Override
    public void generateReceipt() {
        Payment.super.generateReceipt();
    }
}
