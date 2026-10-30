package Oops.inheritance;

class Payment1 {
    void process() {
        System.out.println("Processing a generic payment.");
    }
}

class CreditCard extends Payment1 {
    @Override
    void process() {
        System.out.println("Processing credit card payment via Stripe.");
    }
}

class PayPal extends Payment1 {
    @Override
    void process() {
        System.out.println("Processing PayPal payment via PayPal API.");
    }
}

public class Payment2 {
    public static void main(String[] args) {
        // Superclass reference pointing to a CreditCard object (Upcasting)
        Payment1 myPayment = new CreditCard();

        // Output: "Processing credit card payment via Stripe."
        myPayment.process();

        // Superclass reference switching to a PayPal object
        myPayment = new PayPal();

        // Output: "Processing PayPal payment via PayPal API."
        myPayment.process();
    }
}
