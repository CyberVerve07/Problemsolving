package dailycode.july19;

// Polymorphism - SMSNotification implements NotificationSender
// SMS notification bhejne ka kaam

public class SMSNotification implements NotificationSender {

    @Override
    public void sendConfirmation(Booking booking) {
        System.out.println("--- SMS Sent ---");
        System.out.println("Hi " + booking.getPassenger().getName() + "! Booking " + booking.getBookingId() + " CONFIRMED. Happy Journey!");
    }

    @Override
    public void sendCancellation(Booking booking) {
        System.out.println("--- SMS Sent ---");
        System.out.println("Hi " + booking.getPassenger().getName() + "! Booking " + booking.getBookingId() + " CANCELLED. Refund in 5-7 days.");
    }
}
