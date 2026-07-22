package dailycode.july22.PaymentGateway;

public class DebitCard extends  PaymentGateway implements Payment{


    public DebitCard(double balance) {
        super();
        setBalance(balance);
    }

    public DebitCard(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    void pay() {
        System.out.println("You Payment is done by using DebitCard: ");
    }




}
