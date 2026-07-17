package dailycode.july17.Code1.AmazonOrderManagementSystem;

public class ClothingOrder extends Order{
    private double discount;

    public ClothingOrder(int orderId, String customerName,
                         double orderAmount, double discount) {

        super(orderId, customerName, orderAmount);
        this.discount = discount;
    }

    @Override
    void calculateFinalPrice() {

         discount=getOrderAmount()-discount ;
        System.out.println("Actual price after discount is :"+discount);



    }
}
