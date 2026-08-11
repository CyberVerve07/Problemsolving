package august.augest8;

import java.util.Scanner;

public class Demo14 {
    public static void main(String[] args) throws ClassNotFoundException {

        try {
            int[] arr = new int[]{10, 20, 30, 40, 50};
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number of elements in the array:");
            int n = sc.nextInt();
            System.out.println("Enter the  first number");
            int firstNumber = sc.nextInt();
            System.out.println("Enter the second number");
            int secondNumber = sc.nextInt();
            int res=firstNumber/secondNumber;
            System.out.println("Division is: " + res);
            String name = null;
            System.out.println(name.length());
            Class.forName("java.lang.String");

        } catch (ArithmeticException a) {
            System.out.println("Arithmetic Exception: " + a.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out Of Bounds Exception: " + e.getMessage());
        } catch (NullPointerException n) {
            System.out.println("Null Pointer Exception: " + n.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println("Class Not Found Exception: " + c.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}