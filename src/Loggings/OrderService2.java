package Loggings;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderService2 {

    // Java ka built-in logger (koi external jar nahi chahiye)
    private static final Logger log = Logger.getLogger(OrderService2.class.getName());

    public void placeOrder(long orderId) {
        log.info("Placing order: " + orderId);

        try {
            // Order placement logic yahan aayega
            log.info("Order placed  /.successfully: " + orderId);

        } catch (Exception ex) {
            log.log(Level.SEVERE, "Order placement failed: " + orderId, ex);
        }
    }

    // Program run karne ke liye main method:
    public static void main(String[] args) {
        OrderService2 service = new OrderService2();
        service.placeOrder(101L);
        service.placeOrder(102L);
    }
}
