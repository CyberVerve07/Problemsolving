package Exceptions;

public class Demo8 {
    //Arrayout of bound exception is a run time exception
    public static void main(String[] args) {


        int arr[] = {1, 2, 3, 4, 5};
          try {
              System.out.println(arr[9]);
          } catch (Exception e) {
              System.out.println("Value is not present in here:");
          }
finally {
              System.out.println("Finally is execute  at least once ");
          }
    }
}