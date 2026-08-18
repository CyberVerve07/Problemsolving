package august.augustSolidDip;

/**
 * Concrete implementation of NotificationChannel for Email delivery.
 * Low-level module implementing the NotificationChannel abstraction.
 */
public class EmailNotificationChannel implements NotificationChannel {

    @Override
    public void send(String recipient, String message) {
        System.out.println("[EMAIL] Sending Email to " + recipient + ": " + message);
    }

    @Override
    public String getChannelName() {
        return "Email Service";
    }
}
