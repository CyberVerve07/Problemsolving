package dailycode.july19;

// =============================================
// NotificationSender Interface - OOP: Abstraction
// Defines contract for all notification types
// =============================================
public interface NotificationSender {
    void sendBookingConfirmation(Booking booking);
    void sendCancellationNotice(Booking booking);
}
