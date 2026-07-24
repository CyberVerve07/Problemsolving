package dailycode.july23;

public class Main {
    public static void main(String[] args) {

        //  PaymentProcess upcast - abstract class ke methods milenge
        PaymentProcess paymentProcess  = new UpiPayment();
        PaymentProcess paymentProcess1 = new Creditcard();

        // Abstract class ke methods
        paymentProcess.details();
        paymentProcess.done();

        paymentProcess1.details();
        paymentProcess1.done();

        //  Static method - directly interface se call hoga
        Payment.pay();

        //  Payment interface upcast - refund() call karne ke liye
        Payment upiPayment      = new UpiPayment();
        Payment creditcardPayment = new Creditcard();

        upiPayment.refund();
        creditcardPayment.refund();

    }
}
