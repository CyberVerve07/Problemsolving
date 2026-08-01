package dailycode.july.day27.QuickBite;

public class NormalDevilery extends DeliveryManagement {

    public NormalDevilery(String deliveryId, String deliveryPartnerName, String customerAddress, String orderId) {
        super(deliveryId, deliveryPartnerName, customerAddress, orderId);
    }

    @Override
    public void deliverOrder() {
        System.out.println("Standard delivery in progress for order: " + getOrderId());
    }

    @Override
    public void calculateDeliveryTime() {
        System.out.println("Estimated Delivery Time: 30 - 45 minutes");
    }
}



