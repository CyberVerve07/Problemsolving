package dailycode.july17.Code1.Abstraction;

public class Gpay extends  Payment{

    public Gpay(double ammount) {
        super();
    }

    @Override
    void pay(double amount) {
        System.out.println("=========================================");
        System.out.println("Payment is done by using Google Pay:  :"+amount);
        System.out.println(amount +" is Credit for your bank Account:");
        System.out.println("===========================================");

    }
}
