package dailycode.july29.cloneable;

public class Order implements Cloneable {

    private  String orderId;
    private  String address;
    private  double  amount;

    //  Create Constructors


    public Order(String orderId, String address, double amount) {
        this.orderId = orderId;
        this.address = address;
        this.amount = amount;
    }

       //Generates the Getters and Setters :

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
