package dailycode.july29.cloneable;

public class Place {
    public static void main(String[] args) throws CloneNotSupportedException {
        Order order=new Order("1", "123 Main St", 100.0);


         Order order1=(Order) order.clone();


        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Address: " + order.getAddress());
        System.out.println("Amount: " + order.getAmount());
        System.out.println("Cloned Order ID: " + order1.getOrderId());
        System.out.println("Cloned Address: " + order1.getAddress());
        System.out.println("Cloned Amount: " + order1.getAmount());


    }
}
