package dailycode.july23.FlipKart;

public interface DeliveryPartner {

    // Methods declared in Interface (default = optional to override)

    // BUG FIX: typo "aceptacceptOrder" fixed to "acceptOrder"
    default void acceptOrder() {

    }

    default void pickupOrder() {

    }

    default void deliverOrder() {

    }
}
