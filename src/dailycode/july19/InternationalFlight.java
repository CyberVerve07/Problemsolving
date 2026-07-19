package dailycode.july19;

// =============================================
// InternationalFlight - OOP: Inheritance + Polymorphism
// Extends Flight, overrides calculateFare()
// Adds international surcharge + passport validation
// =============================================
public class InternationalFlight extends Flight {

    private double internationalSurcharge; // flat surcharge in Rs.
    private double airportTaxRate;         // airport tax percentage
    private String destinationCountry;

    public InternationalFlight(String flightNumber, String airline, String source, String destination,
                               String departureTime, String arrivalTime, double basePrice,
                               int totalSeats, double internationalSurcharge,
                               double airportTaxRate, String destinationCountry) {
        super(flightNumber, airline, source, destination,
              departureTime, arrivalTime, basePrice, totalSeats);
        this.internationalSurcharge = internationalSurcharge;
        this.airportTaxRate = airportTaxRate;
        this.destinationCountry = destinationCountry;
    }

    // =============================================
    // Passport Validation - Encapsulation logic
    // International flights REQUIRE valid passport
    // =============================================
    public boolean validatePassport(Passenger passenger) {
        String passport = passenger.getPassportNumber();
        return passport != null && !passport.trim().isEmpty() && !passport.equalsIgnoreCase("N/A");
    }

    // =============================================
    // Overriding calculateFare - Polymorphism
    // International: Base Price + Surcharge + Airport Tax
    // Child (<12) : 40% discount
    // Senior (>=60): 20% discount
    // =============================================
    @Override
    public double calculateFare(Passenger passenger) {
        double discountedBase = getBasePrice();

        switch (passenger.getAgeCategory()) {
            case "CHILD":
                discountedBase = getBasePrice() * 0.60; // 40% discount
                System.out.printf("  [Discount] Child fare applied (40%% off): Rs. %.2f%n", discountedBase);
                break;
            case "SENIOR":
                discountedBase = getBasePrice() * 0.80; // 20% discount
                System.out.printf("  [Discount] Senior citizen fare applied (20%% off): Rs. %.2f%n", discountedBase);
                break;
            default:
                System.out.printf("  [Info] Adult fare (no discount): Rs. %.2f%n", discountedBase);
        }

        double airportTaxAmount = discountedBase * (airportTaxRate / 100);
        double totalFare = discountedBase + internationalSurcharge + airportTaxAmount;

        System.out.printf("  [International Surcharge] Rs. %.2f added%n", internationalSurcharge);
        System.out.printf("  [Airport Tax %.1f%%] Rs. %.2f added%n", airportTaxRate, airportTaxAmount);
        System.out.printf("  [Total Fare] Rs. %.2f%n", totalFare);

        return totalFare;
    }

    @Override
    public String getFlightType() {
        return "INTERNATIONAL";
    }

    // Getters
    public String getDestinationCountry() { return destinationCountry; }
    public double getInternationalSurcharge() { return internationalSurcharge; }
    public double getAirportTaxRate() { return airportTaxRate; }
}
