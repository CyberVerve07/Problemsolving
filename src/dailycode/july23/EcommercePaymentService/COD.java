package dailycode.july23.EcommercePaymentService;

public class COD extends  BasePayment implements Payment{
    public COD(String paymentId, double amount, String customerName) {
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
