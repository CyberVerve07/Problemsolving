package dailycode.july23.EcommercePaymentService;

public class Creditcart extends BasePayment implements   Payment{


    public Creditcart(String paymentId, double amount, String customerName) {
        super(paymentId, amount, customerName);
    }

    @Override
    public void validate() {
        Payment.super.validate();
    }



    @Override
    public void generateReceipt() {
        Payment.super.generateReceipt();
    }


    @Override
    public void pay() {

    }
}
