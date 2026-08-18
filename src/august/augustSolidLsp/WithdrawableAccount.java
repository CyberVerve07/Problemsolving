package august.augustSolidLsp;

/**
 * Interface for accounts that support withdrawal functionality.
 * Separating withdrawal capability ensures we don't force non-withdrawable accounts
 * (like Fixed Deposit) to implement a withdraw method that throws UnsupportedOperationException.
 * 
 * Liskov Substitution Principle (LSP):
 * Any implementation of WithdrawableAccount can be substituted wherever a WithdrawableAccount is expected,
 * without unexpected failures or broken contracts.
 */
public interface WithdrawableAccount extends Account {
    void withdraw(double amount);
}
