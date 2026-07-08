package dailycode.july8;

public class check {
    public static void main(String[] args) {
        Bank run=new Bank();
        run.checkBalance(100000);
        run.withdraw(50000);

        System.out.println("Account holder name is :"+run.getAccountHolderName("Aditya"));
    }
}
