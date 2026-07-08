package dailycode.july03;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Creating two user accounts with custom PINs
        Code06 user1 = new Code06("Rajat", 5000.0, 1289);
        Code06 user2 = new Code06("Aditya", 1000.0, 4321);
        Code06 user3=new Code06("Mohan",1000000,8080);
        
        System.out.println("==================================");
        System.out.println("    WELCOME TO UPI BANKING APP    ");
        System.out.println("==================================");
        System.out.println("Account 1: " + user1.accountHolder + " | Balance: Rs. 5000.0 | UPI PIN: 1289");
        System.out.println("Account 2: " + user2.accountHolder + " | Balance: Rs. 1000.0 | UPI PIN: 4321");
        System.out.println("==================================");
        
        while (true) {
            System.out.println("\nSelect an Option (Logged in as " + user1.accountHolder + "):");
            System.out.println("1. Check Balance (UPI PIN required)");
            System.out.println("2. Deposit Money (Direct Credit)");
            System.out.println("3. Withdraw Money (UPI PIN required)");
            System.out.println("4. Transfer Money to " + user2.accountHolder + " (UPI PIN required)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    user1.display();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: Rs. ");
                    double depAmt = sc.nextDouble();
                    user1.deposited(depAmt);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: Rs. ");
                    double wdAmt = sc.nextDouble();
                    user1.withdral(wdAmt);
                    break;
                case 4:
                    System.out.print("Enter amount to transfer to " + user2.accountHolder + ": Rs. ");
                    double transAmt = sc.nextDouble();
                    user1.transfer(user2, transAmt);
                    break;
                case 5:
                    System.out.println("Thank you for using UPI Banking!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}