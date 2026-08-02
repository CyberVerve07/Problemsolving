package dailycode.july.day27.QuickBite;

public class UpiPayment implements Payment {

    private NotificationService notificationService = new NotificationService();

    @Override
    public void pay() {
        System.out.println("Payment done using UPI.");
    }

    @Override
    public boolean processPayment(double amount, Authentication user, String foodItem) {
        System.out.println("\n[PAYMENT INITIATED] UPI Payment (Google Pay / PhonePe) for " + foodItem + " | Amount: â‚¹" + amount);
        System.out.println("Verifying UPI PIN...");
        System.out.println("[PAYMENT SUCCESSFUL] â‚¹" + amount + " debited via UPI.");
        System.out.println("Order Confirmed! Your item '" + foodItem + "' is being prepared. ðŸ”");

        if (user != null) {
            notificationService.sendSMSNotification(user.getPhoneNumber(),
                    "UPI Payment of â‚¹" + amount + " successful for " + foodItem + ". Order confirmed!");
            notificationService.sendEmailNotification(user.getEmail(),
                    "UPI Payment Receipt - " + foodItem,
                    "Hi " + user.getName() + ",\nPayment of â‚¹" + amount + " via UPI for " + foodItem + " was successful.");
        }
        return true;
    }
}

