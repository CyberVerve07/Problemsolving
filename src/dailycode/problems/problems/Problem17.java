package dailycode.problems.problems;

import java.util.Scanner;

public class Problem17 {
    public static void main(String[] args) {

        System.out.println("Calcuating the Grade");
        System.out.println("Enter the Marks");
        Scanner input=new Scanner(System.in);
        int marks =input.nextInt();

        if (marks>90) {
            System.out.println("Cong youa achive grade A");
        } else if (marks>75) {
            System.out.println("Cong you achive grade B");
        } else if (marks>60) {
            System.out.println("cong you achive grade B+");
        } else if (marks>50) {
            System.out.println("You achive C grade");
        } else if (marks>=33) {
            System.out.println("Pass");
        }else {
            System.out.println("Fail ");
        }}}
