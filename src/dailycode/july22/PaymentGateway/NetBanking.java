package dailycode.july22.PaymentGateway;

public class NetBanking  extends  PaymentGateway implements Payment{
    public NetBanking(double balance) {
        super();
        setBalance(balance);
    }
    public NetBanking(double balance, String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
        setBalance(balance);
    }

    @Override
    void pay() {
        System.out.println("Payment is done by using  NetBanking : ");


    }
    @Override
    public void  refund(){
        System.out.println("Refund is Credit :");
    }
}


