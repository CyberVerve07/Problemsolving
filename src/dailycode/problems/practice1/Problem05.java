package dailycode.problems.practice1;

import java.util.Scanner;

public class Problem05 {
    public static void main(String[] args) {
        System.out.println("Enter the table number");
        Scanner  input=new Scanner(System.in);
        int number= input.nextInt();
        for (int i=0;i<=10;i++){
            System.out.println(i*number);
        }
    }
}
