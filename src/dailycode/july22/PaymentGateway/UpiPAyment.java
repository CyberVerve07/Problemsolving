package dailycode.july22.PaymentGateway;

public class UpiPAyment extends PaymentGateway implements  Payment{


    public UpiPAyment(double balance) {
        super();
    }

    public UpiPAyment(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public UpiPAyment(int i, String aditya, String number) {

    }


    @Override
    void pay() {

        System.out.println("Payment is done by Using G.Pay ");
         double payment;
        System.out.println("");






    }
}
