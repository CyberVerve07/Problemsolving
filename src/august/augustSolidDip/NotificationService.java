package august.augustSolidDip;

import java.util.List;

/**
 * High-Level Module responsible for orchestrating user alert notifications.
 * 
 * DEMONSTRATING DEPENDENCY INVERSION PRINCIPLE (DIP):
 * Without DIP: NotificationService would instantiate EmailNotificationChannel or SmsNotificationChannel
 * using `new EmailNotificationChannel()`, tightly coupling this high-level class to specific concrete details.
 * 
 * With DIP: NotificationService depends strictly on the `NotificationChannel` interface abstraction.
 * Concrete channels are injected via Constructor Injection. Adding new notification channels
 * (e.g. PushNotification, Telegram) requires ZERO changes to NotificationService!
 */
public class NotificationService {

    private final NotificationChannel primaryChannel;

    // Constructor Injection (Dependency Injection honoring DIP)
    public NotificationService(NotificationChannel primaryChannel) {
        this.primaryChannel = primaryChannel;
    }

    public void notifyUser(String recipient, String message) {
        System.out.println("\nUsing Channel: " + primaryChannel.getChannelName());
        primaryChannel.send(recipient, message);
    }

    /**
     * Notify user across multiple injected channels simultaneously.
     */
    public void notifyUserAllChannels(List<NotificationChannel> channels, String recipient, String message) {
        System.out.println("\n--- Broadcast Notification via Multiple Channels ---");
        for (NotificationChannel channel : channels) {
            channel.send(recipient, message);
        }
    }
}
