package august.augustSolidOcp;

// Open/Closed Principle (OCP):
// Interface defines the contract for interest calculation.
// Open for Extension (we can add new calculators), Closed for Modification (existing calculators don't change).
public interface InterestCalculator {
    double calculateInterest(double balance);
}
