package august.augustSolidDip;

/**
 * Concrete implementation of NotificationChannel for WhatsApp messaging.
 * Low-level module implementing the NotificationChannel abstraction.
 */
public class WhatsAppNotificationChannel implements NotificationChannel {

    @Override
    public void send(String recipient, String message) {
        System.out.println("[WHATSAPP] Sending WhatsApp message to " + recipient + ": " + message);
    }

    @Override
    public String getChannelName() {
        return "WhatsApp Business API";
    }
}
