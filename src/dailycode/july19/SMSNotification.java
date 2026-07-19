package dailycode.july19;

// =============================================
// SMSNotification - OOP: Polymorphism
// Implements NotificationSender interface
// Simulates sending SMS notifications
// =============================================
public class SMSNotification implements NotificationSender {

    @Override
    public void sendBookingConfirmation(Booking booking) {
        System.out.println("\n📱 [SMS NOTIFICATION]");
        System.out.printf("   To   : %s%n", booking.getPassenger().getPhone());
        System.out.printf("   MSG  : IndiAir: Dear %s, Flight %s on %s CONFIRMED. Seat %d. Fare Rs.%.0f. BKG-%d%n",
                booking.getPassenger().getName(),
                booking.getFlight().getFlightNumber(),
                booking.getFlight().getDepartureTime(),
                booking.getSeatNumber(),
                booking.getFinalFare(),
                booking.getBookingId());
        System.out.println("   ✅ SMS sent successfully!\n");
    }

    @Override
    public void sendCancellationNotice(Booking booking) {
        System.out.println("\n📱 [SMS NOTIFICATION]");
        System.out.printf("   To   : %s%n", booking.getPassenger().getPhone());
        System.out.printf("   MSG  : IndiAir: Booking BKG-%d for %s has been CANCELLED. Refund in 5-7 days.%n",
                booking.getBookingId(),
                booking.getPassenger().getName());
        System.out.println("   ✅ Cancellation SMS sent!\n");
    }
}
