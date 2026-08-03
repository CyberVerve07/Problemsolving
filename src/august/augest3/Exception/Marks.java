package august.augest3.Exception;

public class Marks {
    public static void main(String[] args) {
        System.out.println("Exception is handle by using the ty catch block ");

        try {
            int[] arr = new int[6];
            System.out.println(arr[9]);
        }
        catch(ArrayIndexOutOfBoundsException ArithmeticException ) {


            System.out.println("Exception is handle ");
        }


        try {
            int num = 10;
            int num2 = 0;
            System.out.println(num / num2);


        } catch (ArithmeticException a) {
            System.out.println("Airthmatic Exception is handle");

        }


         try {
             String name = null;
             System.out.println(name.length());
         } catch (NullPointerException n) {
             System.out.println("Null pointer Exception is handle ");

         }




        }}