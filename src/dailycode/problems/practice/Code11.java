package dailycode.problems.practice;

import java.util.Scanner;

public class Code11 {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner sc= new Scanner(System.in);
        int num = sc.nextInt();
        if (num==0){
            System.out.println("Number is Zero");

        } else if (num>0) {
            System.out.println("Number is postive");

        }
        else {
            System.out.println("Number is negative ");
        }
    }
}
