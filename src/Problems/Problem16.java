package Problems;

import java.util.Scanner;

public class Problem16 {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner input=new Scanner(System.in);
        int num= input.nextInt();
        //divisible by both 3 and 5
        //only divisible by 3
        //only divisible by 5
        //none
        if (num % 3 == 0 && num % 5 == 0){

            System.out.println("Divisible by both");
            
        } else if (num % 3==0) {
            System.out.println("Only divide by 3");

            
        } else if (num % 5==0) {
            System.out.println("only divisible by 5");


        }
            else {
            System.out.println("non");
        }
    }}

