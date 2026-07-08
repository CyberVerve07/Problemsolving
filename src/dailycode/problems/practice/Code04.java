package dailycode.problems.practice;

import java.util.Scanner;

public class
Code04 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the  number");
        int number= input.nextInt();;
        if(number % 2 == 0){
            System.out.println("Number is even");

        }
        else {
            System.out.println("Number is odd");
        }
    }
}
