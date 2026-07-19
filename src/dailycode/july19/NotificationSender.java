package dailycode.july19;

// Interface - Abstraction
// Notification bhejne ka kaam yahan define hoga

public interface NotificationSender {

    void sendConfirmation(Booking booking);

    void sendCancellation(Booking booking);
}
