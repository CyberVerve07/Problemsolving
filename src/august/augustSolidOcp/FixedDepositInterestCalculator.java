package august.augustSolidOcp;

// Extension 2: Fixed Deposit Interest (7.5%)
public class
FixedDepositInterestCalculator implements InterestCalculator {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.075;
    }
}
