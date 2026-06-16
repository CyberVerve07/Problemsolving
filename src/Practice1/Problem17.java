package Practice1;

import java.util.Scanner;

public class Problem17 {
    static void atm() {
        System.out.println("Enter your Atm pin");
        Scanner input = new Scanner(System.in);
        int pin = input.nextInt();
        if (pin != 1234) {
            System.out.println(" Try again Reenter your pin");
            System.out.println("Enter your pin 2nd attempt");

            int pin2 = input.nextInt();

            System.out.println("Enter 3rd Attempt");

            int pin3 = input.nextInt();
            System.out.println("You Enter 3 times wrong pin tey again after 5 minuts ");

        } else {

            System.out.println("Enter your current balance  ");
            float currentBalance=input.nextInt();
            System.out.println("Enter the amount you want to Widral  Amount");
       Scanner sc=new Scanner(System.in);

   int amount= sc.nextInt();

       if (currentBalance>=amount){
           System.out.println("Widral is Sucessfull");

       }
       else {
           System.out.println("Your Enter Current balance is low ");
       }}}

    public static void main(String[] args) {
        atm();
    }}


