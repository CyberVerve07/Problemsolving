package dailycode.july16.BlinkitDelivery;

public class ExpressDelivery extends Order{
    public ExpressDelivery(String customerName, String productId) {
        super(customerName, productId);
    }

    @Override
    void placeOrder() {
        super.placeOrder();
        System.out.println(" Your Order  is Delivered in 5 minuts with a special gift  "+getProductId());
    }
}
