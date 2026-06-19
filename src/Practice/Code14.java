package Practice;

import java.util.Scanner;

public class Code14 {

    static int pin = 1234;
    static String name;
    static double balance;

    static void login() {

        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {

            System.out.print("Enter ATM PIN: ");
            int userPin = input.nextInt();

            if (userPin == pin) {
                System.out.println("Login Successful");
                menu();
                return;
            } else {
                System.out.println("Wrong PIN");

                if (i < 3) {
                    System.out.println("Attempts Left: " + (3 - i));
                }
            }
        }

        System.out.println("ATM Blocked");
    }

    static void menu() {

        Scanner input = new Scanner(System.in);

        while (true) {

            System.out.println("\n========= SBI ATM =========");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter Choice : ");

            int choice = input.nextInt();

            if (choice == 1) {

                System.out.println("\nCustomer Name : " + name);
                System.out.println("Current Balance : " + balance);

            } else if (choice == 2) {

                System.out.print("Enter Deposit Amount : ");
                double deposit = input.nextDouble();

                if (deposit > 0) {

                    balance = balance + deposit;
                    System.out.println("Deposit Successful");
                    System.out.println("Updated Balance : " + balance);

                } else {

                    System.out.println("Invalid Amount");

                }

            } else if (choice == 3) {

                System.out.print("Enter Withdraw Amount : ");
                double withdraw = input.nextDouble();

                if (withdraw <= 0) {

                    System.out.println("Invalid Amount");

                } else if (withdraw > balance) {

                    System.out.println("Insufficient Balance");

                } else {

                    balance = balance - withdraw;
                    System.out.println("Withdrawal Successful");
                    System.out.println("Remaining Balance : " + balance);

                }

            } else if (choice == 4) {

                System.out.println("Thank You For Using SBI ATM");
                break;

            } else {

                System.out.println("Invalid Choice");

            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Customer Name : ");
        name = input.nextLine();

        System.out.print("Enter Initial Balance : ");
        balance = input.nextDouble();

        login();

    }
}