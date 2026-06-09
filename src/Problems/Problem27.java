package Problems;

import java.util.Scanner;

 class CountNumbers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int positive = 0;
        int negative = 0;
        int zero = 0;

        for (int i = 1; i <= 5; i++) {

            System.out.println("Enter Number");
            int num = input.nextInt();

            if (num > 0) {
                positive++;
            }

            else if (num < 0) {
                negative++;
            }

            else {
                zero++;
            }
        }
        System.out.println("Positive = " + positive);
        System.out.println("Negative = " + negative);
        System.out.println("Zero = " + zero);
    }
}