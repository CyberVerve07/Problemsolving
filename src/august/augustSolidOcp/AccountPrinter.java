package august.augustSolidOcp;

// Single Responsibility Principle (SRP):
// This class is responsible ONLY for printing account details and receipts.
public class AccountPrinter {

    public void printAccountDetails(Account account) {
        System.out.println("=======================================");
        System.out.println("Account ID    : " + account.getAccountId());
        System.out.println("Holder Name   : " + account.getAccountHolderName());
        System.out.println("Current Balance: ₹" + account.getBalance());
        System.out.println("=======================================");
    }
}
