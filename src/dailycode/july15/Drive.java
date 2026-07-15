package dailycode.july15;

public class Drive{
    ;
    //Method Overloading is:: Having multiple versions of same method with in the class::
    //Overloading happen within the class only :
     //Overriding happen in the parent and class :: rules same method name,same
    //Method name should be same
    //Order of args type and no of types should be not same
    //No role of access modifier and return type
    //Static and
    // USe -> We want to give flexibility to the color eg: ;login with no,login with otp login,login with email,
    //Static and private can be
    // Overload::

    //Based on the situation method behave differently:



}
  class userLogin{

     void  login(String mobileNo,int opt){
         System.out.println("USer login with mob no and otp ");
     }


      void login(String facebook,String X){
          System.out.println("Login with Facebook or Twitter ");

         }

           void login(String gmail){
               System.out.println("USe login with email::");
           }

  }

