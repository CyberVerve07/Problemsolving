package dailycode.july23;

public class UpiPayment  extends PaymentProcess  implements Payment {


    @Override
    void done() {
        System.out.println("Payment is Done By using G_Pay ");
    }



    @Override
    public void refund() {
        Payment.super.refund();
    }
}
