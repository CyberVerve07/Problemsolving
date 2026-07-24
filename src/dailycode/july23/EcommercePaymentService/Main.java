package dailycode.july23.EcommercePaymentService;

public class Main {
    public static void main(String[] args) {
        BasePayment payment= new  UpiPayment("730383083",200,"Aditya");

        payment.printDetails();

    }
}
