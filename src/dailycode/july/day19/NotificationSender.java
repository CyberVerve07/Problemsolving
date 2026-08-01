package dailycode.july.day19;

// Interface - Abstraction
// Notification bhejne ka kaam yahan define hoga

public interface NotificationSender {

    void sendConfirmation(Booking booking);

    void sendCancellation(Booking booking);
}
