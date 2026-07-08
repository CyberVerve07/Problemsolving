package dailycode.problems.problems;

import java.util.Scanner;
public class Problem23 {
    public static void main(String[] args) {
        // username = admin
        // password = 1234

        String uname = "admin";
        int pass = 1234;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Username:");
        String userName = input.nextLine();   // string input

        System.out.println("Enter the Password:");
        int password = input.nextInt();       // integer input

        if (userName.equalsIgnoreCase(uname) && password == pass) {
            System.out.println("Login successful");
        } else if (!userName.equalsIgnoreCase(uname) && password == pass) {
            System.out.println("Wrong Username");
        } else if (userName.equalsIgnoreCase(uname) && password != pass) {
            System.out.println("Wrong Password");
        } else {
            System.out.println("Both Username and Password are wrong");
        }

        input.close();
    }
}
