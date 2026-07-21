package array;

import java.util.Scanner;

 class Code11 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] arr = new int[5];

        System.out.println("Enter 5 Integer Numbers:");

        // Input
        for (int i = 0; i < arr.length; i++) {

            arr[i] = input.nextInt();

        }

        System.out.println("\nArray Elements:");

        // Print
        for (int j : arr) {

            System.out.println(j);

        }

        input.close();
    }
}