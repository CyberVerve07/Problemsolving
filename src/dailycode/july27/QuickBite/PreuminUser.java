package dailycode.july27.QuickBite;

public class PreuminUser extends DeliveryManagement {
    public PreuminUser(String deliveryId, String deliveryPartnerName, String customerAddress, String orderId) {
        super(deliveryId, deliveryPartnerName, customerAddress, orderId);
    }

    @Override
    public void deliverOrder() {
        System.out.println("Express delivery for Premium Customer. Free Delivery Applied!");
    }

    @Override
    public void calculateDeliveryTime() {
        System.out.println("Estimated Delivery Time: 10 - 15 minutes");
    }
}

