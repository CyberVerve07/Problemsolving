package Collection.Set;

public class OrderService {


    private String orderType;
    private String userName;
    private String address;
    private double price;

    public OrderService(String orderType, String userName, String address, double price) {
        this.orderType = orderType;
        this.userName = userName;
        this.address = address;
        this.price = price;
    }

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }


}