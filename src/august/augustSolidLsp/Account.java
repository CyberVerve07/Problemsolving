package august.augustSolidLsp;

/**
 * Base Account interface representing the core behavior of all bank accounts.
 * Every account supports retrieving account details, checking balance, and depositing money.
 */
public interface Account {
    String getAccountNumber();
    String getAccountHolderName();
    double getBalance();
    void deposit(double amount);
}
