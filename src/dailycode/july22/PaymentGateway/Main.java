package dailycode.july22.PaymentGateway;

public class Main {
    public static void main(String[] args) {

        PaymentGateway done = new UpiPAyment(900.0, "Aditya", "73084403083");
          NetBanking done1=new NetBanking(3000,"Prashant","93039393029");
          PaymentGateway done3=new CreditCard("Prachi","3838338309",9208);
     //     done1.deposit();
        //  done1.withdraw();
         // done1.refund();

           done3.pay();
           done3.withdraw();
           done3.deposit();
          






    }
}
