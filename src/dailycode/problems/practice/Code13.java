package dailycode.problems.practice;

import java.util.Scanner;

public class Code13 {

    static int findSquare(int num) {
        return num * num;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a Number: ");
        int num = input.nextInt();

        int square = findSquare(num);

        System.out.println("Square = " + square);

        input.close();
    }
}