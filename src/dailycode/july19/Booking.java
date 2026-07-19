package dailycode.july19;

// Booking class - Encapsulation
// Ek booking ki sari details yahan store hogi

public class Booking {

    private int bookingId;
    private Passenger passenger;
    private Flight flight;
    private double finalFare;
    private String status;

    // Constructor
    public Booking(int bookingId, Passenger passenger, Flight flight, double finalFare) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.flight = flight;
        this.finalFare = finalFare;
        this.status = "CONFIRMED";
    }

    // Booking cancel karna
    void cancelBooking() {
        this.status = "CANCELLED";
        flight.cancelSeat();
    }

    // Booking ki details print karna
    void displayBooking() {
        System.out.println("=====================");
        System.out.println("Booking Details :");
        System.out.println("Booking ID   : " + bookingId);
        System.out.println("Status       : " + status);
        System.out.println("Passenger    : " + passenger.getName());
        System.out.println("Flight       : " + flight.getFlightNumber());
        System.out.println("From         : " + flight.getSource());
        System.out.println("To           : " + flight.getDestination());
        System.out.println("Final Fare   : Rs. " + finalFare);
        System.out.println("=====================");
    }

    // Getters
    public int getBookingId()   { return bookingId; }
    public String getStatus()   { return status; }
    public Passenger getPassenger() { return passenger; }
}
