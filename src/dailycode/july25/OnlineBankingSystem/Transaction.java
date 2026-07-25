package dailycode.july25.OnlineBankingSystem;

public class Transaction  {

   public String transactionId;
      public String fromAccount;
    public String toAccount;
        public double amount;
       public  String  dateTime;
         public  String   status;

    public Transaction(String transactionId, String fromAccount, String toAccount, double amount, String dateTime, String status) {
        this.transactionId = transactionId;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.dateTime = dateTime;
        this.status = status;


          //Function for Show the details ::::

    }
     public void  showDetails(){
         System.out.println("Transaction details are :::::::::::::::::::::::");
         System.out.println("Transaction id is "+transactionId);
         System.out.println("From account ::"+fromAccount);
         System.out.println("To Account is :"+toAccount);
         System.out.println("Amount is :"+amount);
         System.out.println("Date and Time is :"+dateTime);
         System.out.println("Status "+status);
         System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::");
         System.out.println();


     }
}
