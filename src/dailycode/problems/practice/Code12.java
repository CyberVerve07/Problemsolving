package dailycode.problems.practice;

import java.util.Scanner;

public class Code12 {
    static  void checkAge(){
        System.out.println("Enter Your age ");
        Scanner sc=new Scanner(System.in);
        int age= sc.nextInt();
        if (age>=18){
            System.out.println("You are eligible");
        }
        else {
            System.out.println("YOu are not eligible for vote");
        }
    }

    public static void main(String[] args) {
        checkAge();
        checkAge();
    }
}
