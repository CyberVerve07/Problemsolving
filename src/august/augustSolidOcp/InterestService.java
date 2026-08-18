package august.augustSolidOcp;

// Open/Closed Principle (OCP):
// InterestService works with the InterestCalculator interface.
// We NEVER need to modify this service when adding new account interest types!
public class InterestService {

    public double computeInterest(Account account, InterestCalculator calculator) {
        double interest = calculator.calculateInterest(account.getBalance());
        System.out.println("Calculated Interest for Account [" + account.getAccountId() + "]: " + interest);
        return interest;
    }
}
