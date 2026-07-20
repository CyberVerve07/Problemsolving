package dailycode.july20.Ecom;

public class PremimuUser extends OrderManagement{
    public PremimuUser(String orderId, int otp, String type) {
        super(orderId, otp, type);
    }

    @Override
    void placeOrder() {
        System.out.println("Your Order has been placed  ");

    }

    @Override
    void editOrder() {
        System.out.println("Click on Top left if you want to edit your Order : ");

    }

    @Override
    void conformOrder() {
        System.out.println("Your Order has been Conformed:");
        System.out.println("OTP is "+getOtp());

    }
}
