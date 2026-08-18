package august.augustSolidDip;

/**
 * Concrete implementation of NotificationChannel for SMS delivery.
 * Low-level module implementing the NotificationChannel abstraction.
 */
public class SmsNotificationChannel implements NotificationChannel {

    @Override
    public void send(String recipient, String message) {
        System.out.println("[SMS] Sending SMS to " + recipient + ": " + message);
    }

    @Override
    public String getChannelName() {
        return "SMS Gateway";
    }
}
