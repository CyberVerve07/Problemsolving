package dailycode.july17.Code1.AmazonOrderManagementSystem;

public class ElectronicsOrder extends Order {

    private final double warrantyCharge;

    public ElectronicsOrder(int orderId, String customerName,
                            double orderAmount, double warrantyCharge) {

        super(orderId, customerName, orderAmount);
        this.warrantyCharge = warrantyCharge;
    }

    @Override
    void calculateFinalPrice() {

        double finalPrice = getOrderAmount() + warrantyCharge;

        System.out.println("Electronics Order");
        System.out.println("Order Amount    : " + getOrderAmount());
        System.out.println("Warranty Charge : " + warrantyCharge);
        System.out.println("Final Price     : " + finalPrice);
    }
}
