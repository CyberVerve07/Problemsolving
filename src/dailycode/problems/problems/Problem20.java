package dailycode.problems.problems;

//Q13. ATM Withdrawal
//
//        Input:
//
//        account balance
//        withdraw amount
//
//        Cases:
//
//        insufficient balance
//        invalid amount
//        withdrawal successful

import java.util.Scanner;

public class Problem20 {
    public static void main(String[] args) {
        System.out.println("Enter the Account Balance");
        Scanner input =new Scanner(System.in);
//        System.out.println("Enter the widrall amount");
        int widralAmount= input.nextInt();
        System.out.println("Enter the widrall amount");
        int balance=input.nextInt();

        if (widralAmount<=balance){
            System.out.println("Invalid amount");
        }
        else{
            System.out.println("Widral Sucessfull");

        }

    }
}
