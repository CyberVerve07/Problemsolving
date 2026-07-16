package dailycode.july16.ZeptoDeliverySystem;

public class Cycle extends  DeliveryPartner{
     public Cycle(String partnerName, int orderId) {
        super(partnerName, orderId);
    }

    @Override
    void deliveryOrder() {
        System.out.println(" Your Order is Delivered by "+getPartnerName()+" Check your Order is "+getOrderId());
    }
}
