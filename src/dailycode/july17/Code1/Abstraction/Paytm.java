package dailycode.july17.Code1.Abstraction;

public class Paytm extends Payment{
    public Paytm(double ammount) {
        super();
    }

    @Override
    void pay(double amount)
    {
        System.out.println("================================");

        System.out.println(" Payment is done by using Paytm");
        System.out.println(amount+ "is Credit to your Bank Account ");
        System.out.println("=====================================");
    }
}
