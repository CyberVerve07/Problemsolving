package august.augest5;

public class Demo15 {

    public static void main(String[] args) {

        try {

            int arr[] = {10, 20};

            System.out.println(arr[5]);

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {

            System.out.println("Exception Handled");
        }
    }
}
