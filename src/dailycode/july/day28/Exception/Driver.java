package dailycode.july.day28.Exception;

import java.util.Arrays;

public class Driver {
    //Execution occur, and it is a Run  time Exception : Checked Exception :
    public static void main(String[] args) {
        int arr[] = new int[9];


        try {
            System.out.println(arr[29]);
            int result= 9/0;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of bounds");



        }
        catch (ArithmeticException e) {
            System.out.println("Arithmetic exception occurred");
        }
        System.out.println("Hello");
        System.out.println();

          //What is Exception and try catch Block in JAva



    }
}