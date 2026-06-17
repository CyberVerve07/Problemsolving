package Practice1;

import java.util.Scanner;

public  class Problem19 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Input
        System.out.println("Enter Customer Id:");
        int customerId = input.nextInt();
        input.nextLine();

        System.out.println("Enter Customer Name:");
        String customerName = input.nextLine();

        System.out.println("Enter Customer Type (Regular / Premium / VIP):");
        String customerType = input.nextLine();

        System.out.println("Enter Purchase Amount:");
        double purchaseAmount = input.nextDouble();

        // Discount variable
        double discountPercentage = 0;

        // Customer type check
        if (customerType.equalsIgnoreCase("Regular")) {
            discountPercentage = 5;
        }
        else if (customerType.equalsIgnoreCase("Premium")) {
            discountPercentage = 10;
        }
        else if (customerType.equalsIgnoreCase("VIP")) {
            discountPercentage = 20;
        }
        else {
            System.out.println("Invalid Customer Type");
            return;
        }

        // Calculations
        double discountAmount =
                (purchaseAmount * discountPercentage) / 100;

        double finalAmount =
                purchaseAmount - discountAmount;

        // Output
        System.out.println("\n----- Customer Details -----");
        System.out.println("Customer Id: " + customerId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer Type: " + customerType);
        System.out.println("Discount Percentage: " + discountPercentage + "%");
        System.out.println("Discount Amount: " + discountAmount);
        System.out.println("Final Amount: " + finalAmount);

    }
}