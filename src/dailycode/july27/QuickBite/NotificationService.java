package dailycode.july27.QuickBite;

public class NotificationService {

    public void sendEmailNotification(String email, String subject, String message) {
        System.out.println("[EMAIL NOTIFICATION] To: " + email);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + message);
        System.out.println("-------------------------------------------------");
    }

    public void sendSMSNotification(String phoneNumber, String message) {
        System.out.println("[SMS NOTIFICATION] Sent to " + phoneNumber + ": " + message);
    }

    public void sendOrderUpdate(String customerName, String orderId, String status) {
        System.out.println("[NOTIFICATION] Hello " + customerName + ", your Order ID #" + orderId + " is now " + status + "!");
    }
}
