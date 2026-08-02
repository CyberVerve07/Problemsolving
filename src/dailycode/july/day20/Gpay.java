package dailycode.july.day20;

public class Gpay extends Payment {
    public Gpay(double amount) {
        super(amount);
    }

    @Override
    void payment() {
        System.out.println("Payment is done by using Google Pay .....");
        System.out.println("Amount Credited from your Account is " + getAmount());
        System.out.println();
    }
}
