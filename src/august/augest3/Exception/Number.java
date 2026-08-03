package august.augest3.Exception;

public class Number {
    public static void main(String[] args) {


         try {
//In try and catch block we write the code to prevent the exception
             int amount = 100;
             int num = 0;
             System.out.println(amount / num);

         } catch (Exception e) {

             System.out.println("Exception  is handled Successfully ");


         }

        System.out.println("Does this line is executed ? ");


    }

}
