package Practice1;

import java.util.Scanner;

public class Problem27 {

    static double add(double a, double b) {
        return a + b;
    }

    static double sub(double a, double b) {
        return a - b;
    }

    static double mul(double a, double b) {
        return a * b;
    }

    static double div(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== Calculator =====");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        System.out.print("Enter your choice: ");
        int choice = input.nextInt();

        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();

        switch (choice) {

            case 1:
                System.out.println("Addition = " + add(num1, num2));
                break;

            case 2:
                System.out.println("Subtraction = " + sub(num1, num2));
                break;

            case 3:
                System.out.println("Multiplication = " + mul(num1, num2));
                break;

            case 4:
                if (num2 == 0) {
                    System.out.println("Division by zero is not possible.");
                } else {
                    System.out.println("Division = " + div(num1, num2));
                }
                break;

            default:
                System.out.println("Invalid Choice");
        }

        input.close();
    }
}