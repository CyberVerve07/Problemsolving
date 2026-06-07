package Problems;

import java.util.Scanner;
public class Problem19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the units");
        int unit = input.nextInt();

        int bill;

        if (unit < 0) {
            System.out.println("Invalid Units");
        }

        else if (unit <= 100) {
            bill = unit * 5;
            System.out.println("Your bill is " + bill);
        }

        else if (unit <= 200) {
            bill = unit * 7;
            System.out.println("Your bill is " + bill);
        }

        else {
            bill = unit * 10;
            System.out.println("Your bill is " + bill);
        }
    }
}