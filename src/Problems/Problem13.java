package Problems;

import java.util.Scanner;

public class Problem13 {
    public static void main(String[] args) {
        System.out.println("Enter your age");
        Scanner input=new Scanner(System.in);
        int age = input.nextInt();
        if (age>=18){
            System.out.println("You are eligible for vote");

        }
        else{
            System.out.println("You are not eligible for vote ");
        }
    }
}
