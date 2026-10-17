package DesignPattens.factory;

/**
 * Factory Class:
 * Decouples client code from concrete payment implementations.
 * It encapsulates object creation logic in one central place.
 */
public class PaymentFactory {

    /**
     * Factory Method to get the appropriate Payment instance.
     *
     * @param paymentType type of payment requested (e.g., "UPI", "CREDIT_CARD", "PAYPAL")
     * @return an instance of Payment
     */
    public static Payment createPayment(String paymentType) {
        if (paymentType == null || paymentType.trim().isEmpty()) {
            throw new IllegalArgumentException("Payment type cannot be null or empty.");
        }

        switch (paymentType.trim().toUpperCase()) {
            case "CREDIT_CARD":
                return new CreditCardPayment();
            case "UPI":
                return new UPIPayment();
            case "PAYPAL":
                return new PayPalPayment();
            default:
                throw new IllegalArgumentException("Unknown payment method: " + paymentType);
        }
    }
}
