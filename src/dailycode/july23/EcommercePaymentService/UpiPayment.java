package dailycode.july23.EcommercePaymentService;

public class UpiPayment  extends BasePayment implements Payment{
    public UpiPayment(String paymentId, double amount, String customerName) {
        super(paymentId, amount, customerName);
    }

    @Override
    public void validate() {
        Payment.super.validate();
        System.out.println("Checking Successful  user is Valid ");
    }

    @Override
    public void generateReceipt() {
        Payment.super.generateReceipt();
        System.out.println("Your Receipt will  be generated : ");
    }

      @Override
    public  void  pay(){
          System.out.println("Payment is Done: ");

      }
}
