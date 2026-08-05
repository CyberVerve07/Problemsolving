package august.augest5;

public class Demo11 {
    public static void main(String[] args) {
        System.out.println("Start Program");  //Execute first

        try {
            System.out.println("Outer Try");  //2nd
            try {
                System.out.println("Inner try");   //Check
                System.out.println(10/0);
            }
             catch (ArithmeticException a){
                 System.out.println("Divide by 0 is not allowed: inner");  //Run
                 System.out.println("Outer end is End ");    //Execute
             }
        }catch (ArithmeticException e){
            System.out.println("Divide by 0 is not allowed :outer  ");   //Skipped
        }

         finally {
            System.out.println("Program is end ");   //Runs
        }



    }
}
