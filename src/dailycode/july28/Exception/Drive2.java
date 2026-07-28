package dailycode.july28.Exception;

public class Drive2 {
    public static void main(String[] args) {

         int arr[]=new int[5];

          try {
              System.out.println(arr[6]);
          }
          catch (ArrayIndexOutOfBoundsException e){
              System.out.println("Exception is Handel: ");
          }
          finally {
              System.out.println("Iam Run Always : ");
          }
        System.out.println("Bhai ab ya finally kya ha ");

    }
}
