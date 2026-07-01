 package Month1.Day27;
import java.util.Scanner;

 class ArraySum {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int arr[] = new int[5];
        int sum = 0;

        System.out.println("Enter 5 Numbers:");

        for (int i = 0; i < arr.length; i++) {

            arr[i] = input.nextInt();
            sum += arr[i];

        }

        System.out.println("Sum = " + sum);

        input.close();
    }
}