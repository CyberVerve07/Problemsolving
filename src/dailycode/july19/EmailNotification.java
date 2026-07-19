package dailycode.july19;

// =============================================
// EmailNotification - OOP: Polymorphism
// Implements NotificationSender interface
// Simulates sending email notifications
// =============================================
public class EmailNotification implements NotificationSender {

    @Override
    public void sendBookingConfirmation(Booking booking) {
        System.out.println("\n📧 [EMAIL NOTIFICATION]");
        System.out.printf("   To      : %s%n", booking.getPassenger().getEmail());
        System.out.printf("   Subject : Booking Confirmed! - BKG-%d%n", booking.getBookingId());
        System.out.printf("   Body    : Dear %s, your flight %s from %s to %s is CONFIRMED.%n",
                booking.getPassenger().getName(),
                booking.getFlight().getFlightNumber(),
                booking.getFlight().getSource(),
                booking.getFlight().getDestination());
        System.out.printf("             Seat: %d | Fare: Rs. %.2f%n",
                booking.getSeatNumber(), booking.getFinalFare());
        System.out.println("   ✅ Email sent successfully!\n");
    }

    @Override
    public void sendCancellationNotice(Booking booking) {
        System.out.println("\n📧 [EMAIL NOTIFICATION]");
        System.out.printf("   To      : %s%n", booking.getPassenger().getEmail());
        System.out.printf("   Subject : Booking Cancelled - BKG-%d%n", booking.getBookingId());
        System.out.printf("   Body    : Dear %s, your booking BKG-%d has been CANCELLED.%n",
                booking.getPassenger().getName(), booking.getBookingId());
        System.out.println("             Refund will be processed in 5-7 business days.");
        System.out.println("   ✅ Cancellation email sent!\n");
    }
}
