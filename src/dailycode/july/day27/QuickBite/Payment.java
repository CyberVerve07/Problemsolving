package dailycode.july.day27.QuickBite;

public interface Payment {

    void pay();

    boolean processPayment(double amount, Authentication user, String foodItem);

    default void refund(double amount, Authentication user) {
        if (user != null) {
            user.setWalletBalance(user.getWalletBalance() + amount);
            System.out.println("[REFUND SUCCESS] Refunded ₹" + amount + " to wallet for " + user.getName());
        }
    }
}

