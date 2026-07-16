package dailycode.july16.BlinkitDelivery;

public class NormalOrder  extends Order{

    public NormalOrder(String customerName, String productId) {
        super(customerName, productId);
    }

    @Override
    void placeOrder() {
        super.placeOrder();
        System.out.println("Your Order is delivered in 20 to 40 minutes : "+getProductId());
    }
}
