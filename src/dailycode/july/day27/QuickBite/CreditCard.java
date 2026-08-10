//package dailycode.july.day27.quickbite;
//
//public class CreditCard implements Payment {
//
//    private NotificationService notificationService = new NotificationService();
//
//    @Override
//    public void pay() {
//        System.out.println("Payment done using Credit Card.");
//    }
//
//    @Override
//    public boolean processPayment(double amount, Authentication user, String foodItem) {
//        System.out.println("\n[PAYMENT INITIATED] Credit Card Payment for " + foodItem + " | Amount: â‚¹" + amount);
//        System.out.println("Authorizing Card & OTP verification...");
//        System.out.println("[PAYMENT SUCCESSFUL] â‚¹" + amount + " charged to Credit Card.");
//        System.out.println("Order Confirmed! Your item '" + foodItem + "' is on its way. ðŸ•");
//
//        if (user != null) {
//            notificationService.sendSMSNotification(user.getPhoneNumber(),
//                    "Credit Card Payment of â‚¹" + amount + " successful for " + foodItem + ".");
//        }
//        return true;
//    }
//}
//
