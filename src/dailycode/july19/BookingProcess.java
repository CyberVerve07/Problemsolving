package dailycode.july19;

// BookingProcess class - similar to july18 ka Process class
// Yahan booking aur cancellation ka kaam hoga
// Polymorphism use ho raha hai - Flight reference se
// DomesticFlight ya InternationalFlight dono handle hoti hai

public class BookingProcess {

    static int bookingCounter = 101; // booking ID ke liye

    // Flight book karna
    void book(Passenger passenger, Flight flight) {

        System.out.println("\n--- Booking Started ---");
        passenger.displayDetails();
        flight.displayFlightInfo();

        // Agar International flight hai to passport check karo
        if (flight instanceof InternationalFlight) {
            InternationalFlight intFlight = (InternationalFlight) flight;
            if (!intFlight.validatePassport(passenger)) {
                System.out.println("Booking FAILED! Passport required for International Flight.");
                return;
            }
            System.out.println("Passport verified successfully!");
        }

        // Seat available hai ya nahi
        if (flight.getAvailableSeats() == 0) {
            System.out.println("Booking FAILED! No seats available.");
            return;
        }

        // Fare calculate karo (Polymorphism - DomesticFlight ya InternationalFlight apna fare calculate karega)
        double fare = flight.calculateFare(passenger);

        // Seat book karo
        flight.bookSeat();

        // Booking banao
        Booking booking = new Booking(bookingCounter, passenger, flight, fare);
        bookingCounter++;

        System.out.println("Booking CONFIRMED!");
        booking.displayBooking();
    }

    // Booking cancel karna
    void cancel(Booking booking) {
        System.out.println("\n--- Cancelling Booking ---");
        booking.cancelBooking();
        System.out.println("Booking " + booking.getBookingId() + " is CANCELLED.");
        System.out.println("Seat restored back to flight.");
    }
}
