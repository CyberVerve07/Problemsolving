package dailycode.july23;

public class Main {
    public static void main(String[] args) {

          PaymentProcess paymentProcess= new UpiPayment() {




          };
          PaymentProcess paymentProcess1=new Creditcard(){

          };
           paymentProcess.details();
           Payment.pay();
           paymentProcess.done();

              paymentProcess1.details();
              paymentProcess1.done();








    }
}
