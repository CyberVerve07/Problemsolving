package dailycode.july20.Ecom;

public class RetailUser  extends  OrderManagement{
    public RetailUser(String orderId, int otp, String type) {
        super(orderId, otp, type);
    }

    @Override
    void placeOrder() {
        System.out.println("Your order has been Placed to Delhi -> Himachal Delivery Shoetree:");

    }

    @Override
    void editOrder() {
        System.out.println("Edit your Order Details:");

    }

    @Override
    void conformOrder() {
        System.out.println("Order has been Conformed : ");
        System.out.println("Your OTP is :"+getOtp());

    }
}
