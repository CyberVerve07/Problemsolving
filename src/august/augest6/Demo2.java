package august.augest6;

public class Demo2 {
    public static void main(String[] args) {
        try {
            String name=null;
            System.out.println(name.length());
            System.out.println(19/0);
            int []arr={29,39,303,3,39,30,40};
            System.out.println(arr[19]);
 //Multi catch block used by pipe operator in java ::
        }
        catch (NullPointerException  | ArithmeticException | ArrayIndexOutOfBoundsException a ) {
            System.out.println(a.getMessage());
        }


    }
}
