package oops.InterPhases;

public class main {
    public static void main(String[] args) {
        Payment p = new PhonePe();
        Payment g=new GoogelPay();


        p.pay();
        g.pay();

    }
}
