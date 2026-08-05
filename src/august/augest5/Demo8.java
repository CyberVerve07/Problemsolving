package august.augest5;

public class Demo8 {

    public static void main(String[] args) {

        try {
            placeOrder("iPhone 16", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }

    }

    public static void placeOrder(String item, int qty) throws IllegalArgumentException {

        //throws is used in a method signature to declare the
        // types of exceptions that the method might pass up to its caller

        System.out.println("Welcome to my application");

        String orderId = "38303";

        System.out.println("Order Item : " + item);
        System.out.println("Order ID   : " + orderId);

        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }

        System.out.println("Quantity   : " + qty);
        System.out.println("Order has been placed successfully.");
    }
}
