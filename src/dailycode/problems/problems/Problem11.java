package dailycode.problems.problems;

import java.util.Scanner;

public class Problem11 {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner input =new Scanner(System.in);
        int num= input.nextInt();
//        System.out.println("Enter the number");
        if(num%2==0){
            System.out.println("Number is even");
        }
        else{
            System.out.println("Number is odd ");
        }


    }

}
