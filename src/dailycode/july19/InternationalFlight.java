package dailycode.july19;

// Inheritance - InternationalFlight extends Flight
// International flight mein passport check hoga + extra charges

public class InternationalFlight extends Flight {

    public String destinationCountry;

    public InternationalFlight(String flightNumber, String airline, String source, String destination,
                               String departureTime, double basePrice, int availableSeats,
                               String destinationCountry) {
        super(flightNumber, airline, source, destination, departureTime, basePrice, availableSeats);
        this.destinationCountry = destinationCountry;
    }

    // Passport valid hai ya nahi check karo
    boolean validatePassport(Passenger passenger) {
        if (passenger.getPassportNumber() == null || passenger.getPassportNumber().equals("N/A")) {
            return false;
        }
        return true;
    }

    // Polymorphism - international fare calculate karega
    // Child ko 40% discount, Senior ko 20%, Adult ko koi nahi
    // Extra Rs. 3000 international surcharge bhi lagega
    @Override
    double calculateFare(Passenger passenger) {

        double fare = getBasePrice();

        if (passenger.getAge() < 12) {
            System.out.println("Child discount 40% applied!");
            fare = fare * 0.60;
        } else if (passenger.getAge() >= 60) {
            System.out.println("Senior citizen discount 20% applied!");
            fare = fare * 0.80;
        } else {
            System.out.println("Adult - No discount");
        }

        // International surcharge add karo
        fare = fare + 3000;
        System.out.println("International Surcharge Rs.3000 added");

        // 8% Airport tax
        double tax = fare * 0.08;
        fare = fare + tax;
        System.out.println("Airport Tax (8%) added : Rs. " + tax);
        System.out.println("Final Fare             : Rs. " + fare);

        return fare;
    }
}
