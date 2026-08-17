package august.augustSolidOcp;

// Extension 1: Savings Account Interest (4%)
public class SavingsInterestCalculator implements InterestCalculator {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.04;
    }
}
