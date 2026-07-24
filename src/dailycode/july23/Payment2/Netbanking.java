package dailycode.july23.Payment2;

public class Netbanking extends PaymentProcess implements Payment {
    @Override
    protected void done() {
        System.out.println("Payment is Done by using  the Netbanking : ");
    }
}
