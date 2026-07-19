package dailycode.july19;

// =============================================
// Booking Class - OOP: Encapsulation
// Holds complete information about a single booking
// =============================================
public class Booking {

    private static int bookingCounter = 1000; // auto-increment booking ID seed

    private int bookingId;
    private Passenger passenger;
    private Flight flight;
    private int seatNumber;
    private double finalFare;
    private BookingStatus status;

    // Constructor - called when a new booking is made
    public Booking(Passenger passenger, Flight flight, int seatNumber, double finalFare) {
        this.bookingId = ++bookingCounter;
        this.passenger = passenger;
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.finalFare = finalFare;
        this.status = BookingStatus.CONFIRMED;
    }

    // Cancel the booking
    public void cancel() {
        this.status = BookingStatus.CANCELLED;
        flight.cancelSeat(); // restore seat back to flight
    }

    // Getters
    public int getBookingId()      { return bookingId; }
    public Passenger getPassenger() { return passenger; }
    public Flight getFlight()       { return flight; }
    public int getSeatNumber()      { return seatNumber; }
    public double getFinalFare()    { return finalFare; }
    public BookingStatus getStatus(){ return status; }

    // Display booking details
    public void displayBooking() {
        System.out.println("===============================================");
        System.out.println("            BOOKING CONFIRMATION              ");
        System.out.println("===============================================");
        System.out.printf("  Booking ID  : BKG-%d%n", bookingId);
        System.out.printf("  Status      : %s%n", status);
        System.out.printf("  Passenger   : %s (Age: %d)%n",
                passenger.getName(), passenger.getAge());
        System.out.printf("  Flight      : %s [%s]%n",
                flight.getFlightNumber(), flight.getFlightType());
        System.out.printf("  Route       : %s --> %s%n",
                flight.getSource(), flight.getDestination());
        System.out.printf("  Departure   : %s | Arrival: %s%n",
                flight.getDepartureTime(), flight.getArrivalTime());
        System.out.printf("  Seat No.    : %d%n", seatNumber);
        System.out.printf("  Final Fare  : Rs. %.2f%n", finalFare);
        System.out.println("===============================================");
    }
}
