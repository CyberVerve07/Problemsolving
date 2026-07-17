package dailycode.july17.Code1.AmazonOrderManagementSystem;

public class GroceryOrder extends Order {

    private final double deliveryCharge;

    public GroceryOrder(int orderId, String customerName,
                        double orderAmount, double deliveryCharge) {

        super(orderId, customerName, orderAmount);
        this.deliveryCharge = deliveryCharge;
    }

    @Override
    void calculateFinalPrice() {

        double finalPrice = getOrderAmount() + deliveryCharge;

        System.out.println("Grocery Order");
        System.out.println("Order Amount    : " + getOrderAmount());
        System.out.println("Delivery Charge : " + deliveryCharge);
        System.out.println("Final Price     : " + finalPrice);
    }
}
