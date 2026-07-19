package dailycode.july19;

// Inheritance - DomesticFlight extends Flight
// Domestic flight mein GST lagega

public class DomesticFlight extends Flight {

    public DomesticFlight(String flightNumber, String airline, String source, String destination,
                          String departureTime, double basePrice, int availableSeats) {
        super(flightNumber, airline, source, destination, departureTime, basePrice, availableSeats);
    }

    // Polymorphism - apna fare calculate karega
    // Child ko 50% discount, Senior ko 30%, Adult ko koi nahi
    @Override
    double calculateFare(Passenger passenger) {

        double fare = getBasePrice();

        if (passenger.getAge() < 12) {
            System.out.println("Child discount 50% applied!");
            fare = fare * 0.50;
        } else if (passenger.getAge() >= 60) {
            System.out.println("Senior citizen discount 30% applied!");
            fare = fare * 0.70;
        } else {
            System.out.println("Adult - No discount");
        }

        // 5% GST add karo
        double gst = fare * 0.05;
        fare = fare + gst;

        System.out.println("GST (5%) added : Rs. " + gst);
        System.out.println("Final Fare     : Rs. " + fare);

        return fare;
    }
}
