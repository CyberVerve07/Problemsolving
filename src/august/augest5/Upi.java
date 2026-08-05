package august.augest5;

public class Upi {
    public static void main(String[] args) {
        try {
            sendMoney("Aditya","Prachi",70000);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }


     public  static void sendMoney(String sender, String receiver, double amount){
        if (amount<=0){
            throw  new IllegalArgumentException("Balance cant be 0");
        }

         if (amount>100000){
             throw  new IllegalArgumentException("Amount should be less than 1 lakh ");
          }
         System.out.println("Payment is done ");


     }

    //Rules
    //sender == receiver
    //amount <= 0
    //amount > 100000
    //
    //Otherwise



}
