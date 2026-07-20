package dailycode.july20;

public class NetBanking extends  Payment{
    public NetBanking(double amount) {
        super(amount);
    }

    @Override
    void payment() {
        System.out.println("Payment done by using NFC card ...."+getAmount());
        System.out.println("Ammount is credit from your Account is "+getAmount());
    }
}
