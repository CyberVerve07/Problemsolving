package dailycode.july19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// =============================================
// BookingSystem - OOP: Encapsulation (Service Class)
// Manages the in-memory database of flights,
// passengers, and bookings.
// =============================================
public class BookingSystem {

    private List<Flight> flights;
    private List<Passenger> passengers;
    private List<Booking> bookings;
    private NotificationSender notifier;

    // Constructor - injects notification strategy (Polymorphism via interface)
    public BookingSystem(NotificationSender notifier) {
        this.flights = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.notifier = notifier;
        loadDefaultData();
    }

    // =============================================
    // Load sample flight and passenger data
    // =============================================
    private void loadDefaultData() {
        // Domestic Flights (GST = 5%)
        flights.add(new DomesticFlight("AI-101", "Air India", "Delhi", "Mumbai",
                "06:00 AM", "08:30 AM", 4500.00, 60, 5.0));
        flights.add(new DomesticFlight("6E-202", "IndiGo", "Mumbai", "Bangalore",
                "09:00 AM", "11:00 AM", 3800.00, 80, 5.0));
        flights.add(new DomesticFlight("SG-303", "SpiceJet", "Delhi", "Kolkata",
                "11:30 AM", "02:00 PM", 5200.00, 50, 5.0));
        flights.add(new DomesticFlight("UK-404", "Vistara", "Hyderabad", "Delhi",
                "03:00 PM", "05:30 PM", 6000.00, 70, 5.0));

        // International Flights (Surcharge Rs. 3000, Airport Tax 8%)
        flights.add(new InternationalFlight("AI-501", "Air India", "Delhi", "Dubai",
                "07:00 AM", "09:30 AM", 18000.00, 40, 3000.00, 8.0, "UAE"));
        flights.add(new InternationalFlight("EK-601", "Emirates", "Mumbai", "London",
                "10:00 PM", "06:00 AM+1", 45000.00, 30, 5000.00, 10.0, "UK"));
        flights.add(new InternationalFlight("SQ-701", "Singapore Airlines", "Chennai", "Singapore",
                "08:00 AM", "02:00 PM", 22000.00, 35, 3500.00, 8.0, "Singapore"));

        // Default Passengers
        passengers.add(new Passenger(1001, "Rahul Sharma", 28, "P1234567",
                "rahul@gmail.com", "9876543210"));
        passengers.add(new Passenger(1002, "Priya Patel", 8, "N/A",
                "priya.mom@gmail.com", "9988776655"));   // Child - No passport (domestic only)
        passengers.add(new Passenger(1003, "Suresh Kumar", 65, "P9876543",
                "suresh@gmail.com", "9123456789"));      // Senior citizen
        passengers.add(new Passenger(1004, "Ananya Singh", 22, "P5432167",
                "ananya@gmail.com", "9812345678"));
    }

    // =============================================
    // Search Flights by Source and Destination
    // =============================================
    public List<Flight> searchFlights(String source, String destination) {
        return flights.stream()
                .filter(f -> f.getSource().equalsIgnoreCase(source)
                          && f.getDestination().equalsIgnoreCase(destination)
                          && f.hasAvailableSeats())
                .collect(Collectors.toList());
    }

    // =============================================
    // Book a flight for a passenger
    // Returns Booking object on success, null on failure
    // =============================================
    public Booking bookFlight(Flight flight, Passenger passenger) {

        // Validate passport for international flights (Encapsulation + Polymorphism)
        if (flight instanceof InternationalFlight) {
            InternationalFlight intFlight = (InternationalFlight) flight;
            if (!intFlight.validatePassport(passenger)) {
                System.out.println("  ❌ BOOKING FAILED: Valid passport number is required for international flights!");
                System.out.printf("     Passenger: %s | Passport: %s%n",
                        passenger.getName(), passenger.getPassportNumber());
                return null;
            }
        }

        // Check seat availability
        if (!flight.hasAvailableSeats()) {
            System.out.println("  ❌ BOOKING FAILED: No seats available on this flight!");
            return null;
        }

        // Calculate fare (Polymorphism - different logic for domestic/international)
        System.out.println("\n  [Fare Calculation for " + passenger.getName() + "]");
        double fare = flight.calculateFare(passenger);

        // Book the seat
        flight.bookSeat();
        int seatNumber = flight.getTotalSeats() - flight.getAvailableSeats();

        // Create booking
        Booking booking = new Booking(passenger, flight, seatNumber, fare);
        bookings.add(booking);

        // Send notifications (Polymorphism - email or SMS depending on notifier injected)
        notifier.sendBookingConfirmation(booking);

        return booking;
    }

    // =============================================
    // Cancel a booking by booking ID
    // =============================================
    public boolean cancelBooking(int bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId
                    && booking.getStatus() == BookingStatus.CONFIRMED) {
                booking.cancel();
                notifier.sendCancellationNotice(booking);
                System.out.printf("  ✅ Booking BKG-%d cancelled successfully!%n", bookingId);
                return true;
            }
        }
        System.out.printf("  ❌ Booking BKG-%d not found or already cancelled!%n", bookingId);
        return false;
    }

    // =============================================
    // View all bookings for a passenger
    // =============================================
    public void viewPassengerBookings(int passengerId) {
        List<Booking> passengerBookings = bookings.stream()
                .filter(b -> b.getPassenger().getPassengerId() == passengerId)
                .collect(Collectors.toList());

        if (passengerBookings.isEmpty()) {
            System.out.println("  No bookings found for passenger ID: " + passengerId);
            return;
        }

        for (Booking b : passengerBookings) {
            b.displayBooking();
        }
    }

    // Getters for access from Main
    public List<Flight> getAllFlights()        { return flights; }
    public List<Passenger> getAllPassengers()  { return passengers; }
    public List<Booking> getAllBookings()       { return bookings; }

    public Passenger findPassengerById(int id) {
        return passengers.stream()
                .filter(p -> p.getPassengerId() == id)
                .findFirst()
                .orElse(null);
    }

    public Flight findFlightByNumber(String flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber))
                .findFirst()
                .orElse(null);
    }
}
