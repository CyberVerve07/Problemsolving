package dailycode.problems.problems;

import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {

        float simpleintrest;
        Scanner input =new Scanner(System.in);
        System.out.println("Enter the Amount");
        int amount= input.nextInt();

        System.out.println("Enter the Time period");
        int time=input.nextInt();

        System.out.println("Enter the Intrest Rate");
        int rate=input.nextInt();

        simpleintrest = (amount * rate * time) / 100f;


        System.out.println("The Simple intrest is " +simpleintrest);

    }
}
