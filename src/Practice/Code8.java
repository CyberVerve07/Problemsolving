package Practice;

import java.util.Scanner;

public class Code8 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your Yearly Income:");
        double income = input.nextDouble();

        if (income <= 200000) {
            System.out.println("You are in BPL Category");
        }
        else if (income <= 1000000) {
            System.out.println("You are Lower Middle Class");
        }
        else if (income <= 10000000) {
            System.out.println("You are Middle Class");

        } else {
            System.out.println("You are Upper Class");
        }

        input.close();
    }
}