package dailycode.july20.Ecom;

public class Reseller  extends  OrderManagement{
    public Reseller(String orderId, int otp, String type) {
        super(orderId, otp, type);
    }

    @Override
    void placeOrder() {
        System.out.println("Order is Done ");
        System.out.println("Your Order id is"+getOrderId());

    }

    @Override
    void editOrder() {
        System.out.println("Click Top Right if you want to edit the order ");

    }

    @Override
    void conformOrder() {
        System.out.println("Your Order is Conformed:");
        System.out.println("Otp is "+getOtp());

    }
}
