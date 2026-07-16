package dailycode.july16.SbiBank;

public class CurrentAccount  extends Account{
    public CurrentAccount(String accountName, String accountNumber, double balance) {
        super(accountName, accountNumber, balance);
    }

    @Override
    void calcResult() {
        super.calcResult();

         double totalBalance=0;

         double intrest =getBalance()*0/100;
         totalBalance=intrest+getBalance();

        System.out.println("==============================");

        System.out.println("Current Account details is :::::");

        System.out.println("Account holder name is "+getAccountName());
        System.out.println("Account number is "+getAccountNumber());
        System.out.println("Account balance is "+getBalance());
        System.out.println("Credit interest "+intrest);
        System.out.println("Your Total Balance after Credit the Intrest "+totalBalance);

    }
}
