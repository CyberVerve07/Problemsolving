package dailycode.july23.EcommercePaymentService;

public interface Payment {

//Creates the method of Interface class :
    //validate()
    //
    //pay()
    //
    //default generateReceipt()
    //
    //static showPaymentMethods()
    //
    //private log()

     public default void validate(){
         System.out.println("Verification in progress....");




    }


    public  default  void  generateReceipt(){
        System.out.println("Payment Receipt should be Generated....");

    }



      public  default void  pay(){
          System.out.println("Payment is process:");


      }


//Static method :
      public  static  void  showPaymentMethods(){
          System.out.println("Payment will be Done: ");

      }


}
