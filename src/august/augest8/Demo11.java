package august.augest8;

import java.util.Scanner;

public class Demo11 {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the first number:");
            int num = sc.nextInt();

            System.out.println("Enter the second number:");
            int num2 = sc.nextInt();

            int result = num / num2;

            System.out.println("The division is " + result);

        } catch (ArithmeticException e) {
            System.out.println("Division by 0 is not possible");
        }
    }
}