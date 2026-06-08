package Problems;

import java.util.Scanner;

public class Problem24 {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        System.out.println("Enter the Balance amount");
        int amount= input.nextInt();
        System.out.println("Enter the Transfer account");
        int transfer= input.nextInt();
//        //Cases
        if(amount<=0){
            System.out.println("Invalid amount");

        } else if (amount>transfer)
        {
            System.out.println("Insufficent balance");

        }
        else {
            System.out.println("Transfer Sucessfull");
        }
    }

        }




