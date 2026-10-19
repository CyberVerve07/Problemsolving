package DesignPattens.strategy;

/**
 * Concrete Strategy 1: Credit Card Payment
 */
public class CreditCardStrategy implements PaymentStrategy {
    private final String cardNumber;
    private final String cardHolderName;

    public CreditCardStrategy(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        // Mask card number for display
        String maskedCard = "****-****-****-" + (cardNumber.length() > 4 ? cardNumber.substring(cardNumber.length() - 4) : cardNumber);
        System.out.printf("[Credit Card] Paid ₹%.2f by %s using card %s%n", amount, cardHolderName, maskedCard);
    }
}
