package dailycode.problems.practice1;

import java.util.Scanner;

 class Problem26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        int sum = 0;

        System.out.println("5 numbers enter kijiye:");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
            sum += numbers[i];
        }

        System.out.println("Numbers ka sum: " + sum);
        sc.close();
    }
}
