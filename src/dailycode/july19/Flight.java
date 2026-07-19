package dailycode.july19;

// Abstract class - Abstraction
// Har flight ka common data yahan hoga
// Subclass calculateFare() implement karegi

public abstract class Flight {

    // private fields - Encapsulation
    private String flightNumber;
    private String airline;
    private String source;
    private String destination;
    private String departureTime;
    private double basePrice;
    private int availableSeats;

    // Constructor
    public Flight(String flightNumber, String airline, String source, String destination,
                  String departureTime, double basePrice, int availableSeats) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.basePrice = basePrice;
        this.availableSeats = availableSeats;
    }

    // Abstract method - har flight apne hisaab se fare calculate karegi (Polymorphism)
    abstract double calculateFare(Passenger passenger);

    // Seat book karna
    void bookSeat() {
        availableSeats = availableSeats - 1;
    }

    // Seat cancel karna
    void cancelSeat() {
        availableSeats = availableSeats + 1;
    }

    // Flight ki details print karna
    void displayFlightInfo() {
        System.out.println("=====================");
        System.out.println("Flight Number : " + flightNumber);
        System.out.println("Airline       : " + airline);
        System.out.println("From          : " + source);
        System.out.println("To            : " + destination);
        System.out.println("Departure     : " + departureTime);
        System.out.println("Base Price    : Rs. " + basePrice);
        System.out.println("Seats Left    : " + availableSeats);
        System.out.println("=====================");
    }

    // Getters
    public String getFlightNumber() { return flightNumber; }
    public String getSource()       { return source; }
    public String getDestination()  { return destination; }
    public double getBasePrice()    { return basePrice; }
    public int getAvailableSeats()  { return availableSeats; }
}
