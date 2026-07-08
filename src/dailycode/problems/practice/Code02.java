package dailycode.problems.practice;
//Weite a code for check the user are eligible for vote
import java.util.Scanner;

public class Code02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter you age");
        int age = input.nextInt();
        if (age>=18) {
            System.out.println("YOu are  eligible for vote ");
        }
        else {
            System.out.println("You are not eligilbe for vote");
        }



        

    }
}
