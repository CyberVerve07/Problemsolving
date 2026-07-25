package dailycode.july25.OnlineBankingSystem;

public class NetBanking  implements  PaymentService{
    @Override
    public void processPayment() {
        System.out.println("Payment is done by using the NetBanking: ");
    }
}
