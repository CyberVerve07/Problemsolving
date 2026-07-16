package dailycode.july16.PaymentGateway;

public class NetBanking extends  Payment {

    public NetBanking(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        super.pay();
        System.out.println(" Payment is done by NetBanking:"+getAmount());
    }
}
