package dailycode.problems.problems;

import java.util.Scanner;

public class Problem14 {
    public static void main(String[] args) {
        System.out.println("Enter the first number");
        Scanner input=new Scanner(System.in);
        int num1= input.nextInt();
        System.out.println("Enter second number");
        int num2= input.nextInt();
        System.out.println("Enter third number");
        int num3= input.nextInt();

        //logic
        if (num1>num2&&num1>num3){
            System.out.println("number 1 is greatest ");
        } else if (num2>num1&&num2>num3)
        {
            System.out.println("Number 2 is Greatest");
        }
        else {
            System.out.println("Number 3 is greatest ");
        }
    }
}
