package dailycode.july16.BlinkitDelivery;

public class ScheduleDelivery extends  Order{
    public ScheduleDelivery(String customerName, String productId) {
        super(customerName, productId);
    }

    @Override
    void placeOrder() {
        super.placeOrder();
        System.out.println(" Your Order should be placed in 10 minutes  "+getProductId());
    }
}
