package dailycode.problems.problems;

import java.util.Scanner;

public class Problem04{
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("Enter celciuss");
        int celcius= input.nextInt();
        int F;
        F = (celcius * 9/5) + 32;
        System.out.println("The Temperature is "+F); }
}
