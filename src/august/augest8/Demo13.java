package august.augest8;

import java.util.Scanner;

public class Demo13 {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the age:");
            String input = sc.nextLine();

            int age = Integer.parseInt(input);

            System.out.println("Your age is: " + age);

        } catch (NumberFormatException e) {

            System.out.println("Invalid age. Please enter a number.");
        }
    }
}