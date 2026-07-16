package dailycode.july16.ZeptoDeliverySystem;

public class Bike extends DeliveryPartner {

    public Bike(String partnerName, int orderId) {
        super(partnerName, orderId);
    }

    @Override
    void deliveryOrder() {
        System.out.println(" Your order is Delivered by "+getPartnerName()+"Please check the Order id "+getOrderId());

    }
}
