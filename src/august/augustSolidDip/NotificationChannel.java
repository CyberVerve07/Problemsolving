package august.augustSolidDip;

/**
 * Abstraction interface for sending notifications.
 * 
 * Dependency Inversion Principle (DIP):
 * High-level modules (e.g. NotificationService) and low-level modules (e.g. Email, SMS)
 * both depend on this abstraction interface rather than depending on each other directly.
 */
public interface NotificationChannel {
    void send(String recipient, String message);
    String getChannelName();
}
