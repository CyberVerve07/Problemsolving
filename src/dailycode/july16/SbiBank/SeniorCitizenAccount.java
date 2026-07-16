package dailycode.july16.SbiBank;

public class SeniorCitizenAccount extends Account {

    public SeniorCitizenAccount(String accountName, String accountNumber, double balance) {
        super(accountName, accountNumber, balance);
    }

    @Override
    void calcResult() {
        super.calcResult();
           double totalBalance=0;
            double intrest =getBalance()*8.5/100;
             totalBalance=intrest+getBalance();


        System.out.println("=======================");

        System.out.println("Senior Citizin Account  :::::;");

        System.out.println("Acount holder name is "+getAccountName());
        System.out.println("Account number is "+getAccountNumber());
        System.out.println("Account balance is "+getBalance());
        System.out.println(" Credit intrest is "+intrest);
        System.out.println(" Total Baalance after Credit intrest "+totalBalance);

    }
}
