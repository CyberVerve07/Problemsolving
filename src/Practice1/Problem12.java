package Practice1;

import java.util.Scanner;

public class Problem12 {
    public static void checkBalance() {
        System.out.println("Enter the Amount you want to widral ");
        Scanner input = new Scanner(System.in);
        int widAmount = input.nextInt();
        System.out.println("Ente the Total amount ");
     int accountBalance = input.nextInt();
      if (widAmount <= accountBalance) {
          System.out.println("Amt process your request");
      }
      else {
          System.out.println("Your Balance is Low");
      }
     String s = "Widral Sucessfull";
    }
    //sub task
    public  static void genRecipt() {
        System.out.println("Total Amount is Widral ");
    }
    public static void smsNotification(){
        System.out.println("The __ Amount is Sucessflly widral");
    }
    public static void main(String[] args) {
        checkBalance();
        genRecipt();
        smsNotification();
    }


}