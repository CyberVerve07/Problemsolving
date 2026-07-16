package dailycode.july16.BlinkitDelivery;

public class ScheduleDelivery extends  Order{
    public ScheduleDelivery(String customerName, String productId) {
        super(customerName, productId);
    }

    @Override
    void placeOrder() {
        super.placeOrder();
        System.out.println(" Your Order is should places in 10 Minuts  "+getProductId());
    }
}
