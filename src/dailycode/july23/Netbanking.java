package dailycode.july23;

public class Netbanking extends PaymentProcess implements Payment{
    @Override
    void done() {
        System.out.println("Payment is Done by using  the Netbanking : ");
    }
}
