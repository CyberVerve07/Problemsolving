package dailycode.july27.QuickBite;

public class UpiPayment implements Payment {

    private NotificationService notificationService = new NotificationService();

    @Override
    public void pay() {
        System.out.println("Payment done using UPI.");
    }

    @Override
    public boolean processPayment(double amount, Authentication user, String foodItem) {
        System.out.println("\n[PAYMENT INITIATED] UPI Payment (Google Pay / PhonePe) for " + foodItem + " | Amount: ₹" + amount);
        System.out.println("Verifying UPI PIN...");
        System.out.println("[PAYMENT SUCCESSFUL] ₹" + amount + " debited via UPI.");
        System.out.println("Order Confirmed! Your item '" + foodItem + "' is being prepared. 🍔");

        if (user != null) {
            notificationService.sendSMSNotification(user.getPhoneNumber(),
                    "UPI Payment of ₹" + amount + " successful for " + foodItem + ". Order confirmed!");
            notificationService.sendEmailNotification(user.getEmail(),
                    "UPI Payment Receipt - " + foodItem,
                    "Hi " + user.getName() + ",\nPayment of ₹" + amount + " via UPI for " + foodItem + " was successful.");
        }
        return true;
    }
}

