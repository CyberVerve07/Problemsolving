package dailycode.july23;

public interface Payment {

   static void  pay(){
       System.out.println("Money Transferred successfully ");

      }


      default void  refund(){
          System.out.println("Refund is Credit in your account under 48 hours: ");

      }

}
