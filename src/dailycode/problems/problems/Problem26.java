package dailycode.problems.problems;

import java.util.Scanner;

public class Problem26 {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        int sum = 0;

        for (int i = 1; i <= num; i++) {
            sum = sum + i;
            System.out.println("The sum is "+sum);

    }
}}
