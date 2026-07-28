package dailycode.july27.QuickBite;

public class WalletPay implements Payment {

    private NotificationService notificationService = new NotificationService();

    @Override
    public void pay() {
        System.out.println("Payment done via QuickBite Wallet.");
    }

    @Override
    public boolean processPayment(double amount, Authentication user, String foodItem) {
        System.out.println("\n[PAYMENT INITIATED] Wallet Payment for " + foodItem + " | Amount: ₹" + amount);

        if (user == null) {
            System.out.println("[PAYMENT FAILED] User details missing!");
            return false;
        }

        if (user.getWalletBalance() >= amount) {
            double remaining = user.getWalletBalance() - amount;
            user.setWalletBalance(remaining);
            System.out.println("[PAYMENT SUCCESSFUL] Paid ₹" + amount + " using Wallet.");
            System.out.println("Remaining Wallet Balance: ₹" + remaining);
            System.out.println("Order Confirmed! Enjoy your " + foodItem + " 🍔🍕");

            notificationService.sendSMSNotification(user.getPhoneNumber(),
                    "Payment of ₹" + amount + " successful for " + foodItem + ". Order confirmed!");
            notificationService.sendEmailNotification(user.getEmail(),
                    "Order Confirmation - " + foodItem,
                    "Dear " + user.getName() + ",\nYour payment of ₹" + amount + " for " + foodItem + " was successful!\nRemaining Wallet Balance: ₹" + remaining);
            return true;
        } else {
            System.out.println("[PAYMENT FAILED] Insufficient Wallet Balance! Available: ₹" + user.getWalletBalance() + ", Required: ₹" + amount);
            notificationService.sendSMSNotification(user.getPhoneNumber(),
                    "Payment failed for " + foodItem + ". Insufficient balance in wallet!");
            return false;
        }
    }
}

