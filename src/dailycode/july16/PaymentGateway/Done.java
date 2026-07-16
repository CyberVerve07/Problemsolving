package dailycode.july16.PaymentGateway;

public class Done {
    public static void main(String[] args) {

         Process a=new Process();   //One obj of a process  is needed

        Payment done=new Gpay(9000);
         Payment done2=new UpiPayment(800);
          Payment done3=new NetBanking(900);

            a.process1(done);



    }
}
