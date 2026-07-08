package dailycode.month1;

public class Day8 {
//static variable
    static String product="I phone16";
    static int gst=18;
    public static void main(String[] args) {
        int price =100000;
        //gst calcuate
        double gstAmount=(gst*price)/100;
        double totalAmount=price+gst;
        System.out.println("Total amount"+totalAmount);

    }
}
