package augustSolid;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Sbi("Aditya", "8494849", "BLR", "93840483938", "Local", 8903, "BTM", 9202);
        
        // Print details using dedicated BankPrinter (SRP compliant)
        BankPrinter printer = new BankPrinter();
        printer.printUserDetails(bank);


    }
}
