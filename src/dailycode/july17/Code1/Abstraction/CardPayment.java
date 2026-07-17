package dailycode.july17.Code1.Abstraction;

public class CardPayment extends Payment{
    public CardPayment(double ammount) {
        super();
    }

    @Override
    void pay(double amount) {

        System.out.println("================================");
        System.out.println("Payment is done by  Credit card:");
        System.out.println(amount+"is credit from you bank :");
        System.out.println("================================");

    }
}
