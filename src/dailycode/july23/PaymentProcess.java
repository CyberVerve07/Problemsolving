package dailycode.july23;

public  abstract  class PaymentProcess {

    //Concrete Method :
     void  details(){
         System.out.println("Payment in Processing..........");
     }

        //Abstract Method:
    abstract  void  done();

//Interfaces in java

    //purpose of interface to solve the multiple inheritance and contract to achieve the 100% abstraction
      // when ever we want to define the contract
    // default method and static is added
    //default purpose is to in future some class don't required so it become optional
    //in Java 9 the Private is come to solve the problem of duplicate of interface :

       //


}
