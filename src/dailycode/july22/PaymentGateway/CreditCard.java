package dailycode.july22.PaymentGateway;

public class CreditCard  extends PaymentGateway implements Payment{
    public CreditCard(double balance) {
        super();
        setBalance(balance);
    }

    public CreditCard(String accountHolderName, String accountNumber,double balance) {
        super(accountHolderName, accountNumber,balance);
    }

    @Override
    void pay() {
        System.out.println("Payment is Done by Using Credit card : ");

    }
     @Override
   public void refund(){
         System.out.println("Your Refund is Credit:");

     }

}
