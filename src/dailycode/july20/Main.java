package dailycode.july20;

public class Main {
    public static void main(String[] args) {
         Payment payment=new Gpay(200) {
         };
         Payment payment1=new NetBanking(5000);

           payment.payment();
           payment1.payment();
    }
}
