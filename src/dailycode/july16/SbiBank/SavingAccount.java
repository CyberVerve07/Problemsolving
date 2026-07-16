package dailycode.july16.SbiBank;

public class SavingAccount extends Account {
    public SavingAccount(String accountName, String accountNumber, double balance) {
        super(accountName, accountNumber, balance);
    }

    @Override
    void calcResult() {
        super.calcResult();
         double totalBanance=0;
         double intrest=getBalance()*5/100;
         totalBanance=intrest+getBalance();

        System.out.println("=======================");

        System.out.println("Saving Account Details are:::::;");

        System.out.println("Acount holder name is "+getAccountName());
        System.out.println("Account number is "+getAccountNumber());
        System.out.println("Account balance is "+getBalance());
        System.out.println(" Credit intrest is "+intrest);
        System.out.println(" Total Baalance after Credit intrest "+totalBanance);

    }
    }

