package Problems;

import java.util.Scanner;

public class Problem18 {
    public static void main(String[] args) {
        System.out.println("Enter the Year");
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
            System.out.println("Leap year");

        }
            else {
            System.out.println("Year is not leap");
        }


    }}
