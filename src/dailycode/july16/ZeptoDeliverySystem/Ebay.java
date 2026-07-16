package dailycode.july16.ZeptoDeliverySystem;

public class Ebay  extends DeliveryPartner{

    public Ebay(String partnerName, int orderId) {
        super(partnerName, orderId);
    }

    @Override
    void deliveryOrder() {
        System.out.println(" Your Order is delivered by "+getPartnerName()+"Please check your order is "+getOrderId());
    }
}
