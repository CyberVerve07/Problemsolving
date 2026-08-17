package august.augustSolid;

public class BankPrinter {

    // Responsible ONLY for printing/displaying user account details
    public void printUserDetails(Bank bank) {
        System.out.println("=======================================");
        System.out.println("The user name is: " + bank.getName());
        System.out.println("User account id is: " + bank.getAccountId());
        System.out.println("User address is: " + bank.getAddress());
        System.out.println("Phone number is: " + bank.getPhoneNo());
        System.out.println("Branch is: " + bank.getBranch());
        System.out.println("Balance is: " + bank.getBalance());
        System.out.println("City is: " + bank.getCity());
        System.out.println("Ifsc code is: " + bank.getIfsceCode());
        System.out.println("=======================================");
    }
}
