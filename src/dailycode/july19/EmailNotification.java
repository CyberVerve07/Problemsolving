package dailycode.july19;

// Polymorphism - EmailNotification implements NotificationSender
// Email notification bhejne ka kaam

public class EmailNotification implements NotificationSender {

    @Override
    public void sendConfirmation(Booking booking) {
        System.out.println("--- Email Sent ---");
        System.out.println("Dear " + booking.getPassenger().getName() + ",");
        System.out.println("Your Booking ID " + booking.getBookingId() + " is CONFIRMED.");
        System.out.println("Thank you for booking with IndiAir!");
    }

    @Override
    public void sendCancellation(Booking booking) {
        System.out.println("--- Email Sent ---");
        System.out.println("Dear " + booking.getPassenger().getName() + ",");
        System.out.println("Your Booking ID " + booking.getBookingId() + " has been CANCELLED.");
        System.out.println("Refund will be processed in 5-7 days.");
    }
}
