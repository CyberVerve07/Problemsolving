package dailycode.july19;

// =============================================
// DomesticFlight - OOP: Inheritance + Polymorphism
// Extends Flight, overrides calculateFare()
// Applies GST tax + age-based discounts
// =============================================
public class DomesticFlight extends Flight {

    private double gstRate; // GST tax percentage (e.g., 5.0 = 5%)

    public DomesticFlight(String flightNumber, String airline, String source, String destination,
                          String departureTime, String arrivalTime, double basePrice,
                          int totalSeats, double gstRate) {
        super(flightNumber, airline, source, destination,
              departureTime, arrivalTime, basePrice, totalSeats);
        this.gstRate = gstRate;
    }

    // =============================================
    // Overriding calculateFare - Polymorphism
    // Domestic: Base Price + GST - Age Discount
    // Child (<12) : 50% discount on base price
    // Senior (>=60): 30% discount on base price
    // Adult       : No discount
    // =============================================
    @Override
    public double calculateFare(Passenger passenger) {
        double discountedBase = getBasePrice();

        switch (passenger.getAgeCategory()) {
            case "CHILD":
                discountedBase = getBasePrice() * 0.50; // 50% discount
                System.out.printf("  [Discount] Child fare applied (50%% off): Rs. %.2f%n", discountedBase);
                break;
            case "SENIOR":
                discountedBase = getBasePrice() * 0.70; // 30% discount
                System.out.printf("  [Discount] Senior citizen fare applied (30%% off): Rs. %.2f%n", discountedBase);
                break;
            default:
                System.out.printf("  [Info] Adult fare (no discount): Rs. %.2f%n", discountedBase);
        }

        double gstAmount = discountedBase * (gstRate / 100);
        double totalFare = discountedBase + gstAmount;

        System.out.printf("  [GST %.1f%%] Rs. %.2f added%n", gstRate, gstAmount);
        System.out.printf("  [Total Fare] Rs. %.2f%n", totalFare);

        return totalFare;
    }

    @Override
    public String getFlightType() {
        return "DOMESTIC";
    }

    public double getGstRate() { return gstRate; }
}
