package august.augest3.Exception;

public class Marks {
    public static void main(String[] args) {
        System.out.println("Exception is handle by using the ty catch block ");

        try {
            int[] arr = new int[6];
            System.out.println(arr[9]);

            String name=null;
            System.out.println(name.length());

        }

        catch (ArrayIndexOutOfBoundsException ArithmeticException) {

            System.out.println("Exception is handle ");

            int num = 10;
            int num2 = 0;
            System.out.println(num / num2);

        }

         catch (ArithmeticException a) {
             System.out.println("Airthmatic Exception is handle");
         }
         catch (NullPointerException n) {
             System.out.println("Null pointer Exception is handle ");
         }
        catch (Exception a){

        }

         finally {
            System.out.println("Close the execption ");
        }
    }
    }