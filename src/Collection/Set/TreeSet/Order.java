package Collection.Set.TreeSet;

public class Order implements Comparable {
    String orderName;
    String orderId;
    String address;
    Boolean paymentType;

    public Order(String orderName, String orderId, String address, Boolean paid) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.address = address;
        this.paymentType = paid;


    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}