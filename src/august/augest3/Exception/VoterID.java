package august.augest3.Exception;

public class VoterID {
    public static void main(String[] args) {


         int age=-9;

          if (age<0){
              System.out.println("Exception is throw:");
              throw new IllegalArgumentException("Invalid age ");

          }
          else {
              System.out.println("Able to vote ");
          }
    }
}
