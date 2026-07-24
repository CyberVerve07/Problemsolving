package dailycode.july23.Payment2;

public interface Payment  {
    int MAX_LIMIT = 10_000;

   static void  pay(){
       System.out.println("Money Transferred successfully ");

      }


      default void  refund(){
          System.out.println("Refund is Credit in your account under 48 hours: ");

      }

}
