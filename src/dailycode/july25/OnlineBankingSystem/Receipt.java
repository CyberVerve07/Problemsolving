package dailycode.july25.OnlineBankingSystem;

public class Receipt {

    public String  receiptId;
       public  String     transactionId;
   double  amount;
         String   dateTime   ;


    public Receipt(String receiptId, String transactionId, double amount, String dateTime) {
        this.receiptId = receiptId;
        this.transactionId = transactionId;
        this.amount = amount;
        this.dateTime = dateTime;
    }


      void generate(){
          System.out.println("Receipt is Generated..........");
      }

     void showRecipt(){

         System.out.println("Show Receipt Details: ");
         System.out.println("=======================");
         System.out.println("Receipt is : "+receiptId);
         System.out.println("Transaction id is :"+transactionId);
         System.out.println("Amount is "+amount);
         System.out.println("Date and time is "+dateTime);
         System.out.println("===========================");
         System.out.println();
     }

}
