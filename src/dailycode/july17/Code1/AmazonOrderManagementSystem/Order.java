package dailycode.july17.Code1.AmazonOrderManagementSystem;

public  abstract class Order {
    private int orderId;
    private String customerName;
    private double orderAmount;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        if (orderId != 0) {
            this.orderId = orderId;
        } else {
            System.out.println("Order id is 0 ");
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        if (orderAmount < 0) {
            this.orderAmount = orderAmount;
        } else {
            System.out.println("Order is not placed");
        }
    }

    public Order(int orderId, String customerName, double orderAmount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderAmount = orderAmount;
    }

     void displayOrderDetails() {
        System.out.println("=====================");
        System.out.println("Orders details are :");
        System.out.println("Order id is " + getOrderId());
        System.out.println("Customer name is :" + getCustomerName());
        System.out.println("Order ammount is " + getOrderAmount());
    }

    abstract void calculateFinalPrice();



}
