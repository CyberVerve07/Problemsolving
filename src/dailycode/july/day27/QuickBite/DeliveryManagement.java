package dailycode.july.day27.QuickBite;

public abstract class DeliveryManagement {

    private String deliveryId;
    private String deliveryPartnerName;
    private String customerAddress;
    private String orderId;

    public DeliveryManagement(String deliveryId, String deliveryPartnerName, String customerAddress, String orderId) {
        this.deliveryId = deliveryId;
        this.deliveryPartnerName = deliveryPartnerName;
        this.customerAddress = customerAddress;
        this.orderId = orderId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryPartnerName() {
        return deliveryPartnerName;
    }

    public void setDeliveryPartnerName(String deliveryPartnerName) {
        this.deliveryPartnerName = deliveryPartnerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void assignDeliveryPartner() {
        System.out.println("Order " + getOrderId() + " assigned to Delivery Partner: " + getDeliveryPartnerName());
    }

    public void trackOrder() {
        System.out.println("Tracking Order " + getOrderId() + " for Address: " + getCustomerAddress());
    }

    public abstract void deliverOrder();

    public abstract void calculateDeliveryTime();
}

