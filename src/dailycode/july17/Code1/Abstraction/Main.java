package dailycode.july17.Code1.Abstraction;

public class Main {

    public static void main(String[] args) {


         Process  done=new Process();

          Payment payment=new Gpay(800);
           Payment payment1=new Paytm(900);
            Payment payment2=new CardPayment(9700);

            done.process(payment);
             done.process(payment1);
             done.process(payment2);
    }
}
