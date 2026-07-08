package dailycode.problems.problems;

import java.util.Scanner;

public class Problem25 {
    public static void main(String[] args) {
        System.out.println("Enter the table number you want multiplication");
        Scanner input=new Scanner(System.in);
        int num= input.nextInt();
//        System.out.println("Enter the table number you wanr multiplication");

        for (int i=1;i<=10;i++){
            System.out.println("Multiplication is"+i*num);
        }
    }
}
