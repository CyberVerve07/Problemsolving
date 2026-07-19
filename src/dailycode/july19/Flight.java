package dailycode.july19;

// =============================================
// Flight Abstract Class - OOP: Abstraction + Encapsulation
// Template for all flight types
// Subclasses MUST implement calculateFare()
// =============================================
public abstract class Flight {

    private String flightNumber;
    private String airline;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private double basePrice;
    private int totalSeats;
    private int availableSeats;

    // Constructor
    public Flight(String flightNumber, String airline, String source, String destination,
                  String departureTime, String arrivalTime, double basePrice, int totalSeats) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.basePrice = basePrice;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    // =============================================
    // Abstract Method - Polymorphism
    // Each flight type calculates fare differently
    // =============================================
    public abstract double calculateFare(Passenger passenger);

    // =============================================
    // Abstract Method - returns flight type label
    // =============================================
    public abstract String getFlightType();

    // Seat Management
    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    public void cancelSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        }
    }

    public boolean hasAvailableSeats() {
        return availableSeats > 0;
    }

    // Getters
    public String getFlightNumber() { return flightNumber; }
    public String getAirline() { return airline; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public double getBasePrice() { return basePrice; }
    public int getTotalSeats() { return totalSeats; }
    public int getAvailableSeats() { return availableSeats; }

    // Display flight details
    public void displayFlightInfo() {
        System.out.println("-----------------------------------------------");
        System.out.printf("  Flight      : %s (%s) [%s]%n", flightNumber, airline, getFlightType());
        System.out.printf("  Route       : %s  -->  %s%n", source, destination);
        System.out.printf("  Departure   : %s  |  Arrival: %s%n", departureTime, arrivalTime);
        System.out.printf("  Base Price  : Rs. %.2f%n", basePrice);
        System.out.printf("  Seats Left  : %d / %d%n", availableSeats, totalSeats);
        System.out.println("-----------------------------------------------");
    }
}
