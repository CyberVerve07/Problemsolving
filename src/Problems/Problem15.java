package Problems;

import java.util.Scanner;

public class Problem15 {
    public static void main(String[] args) {
        System.out.println("Enter the first number");
        Scanner input =new Scanner(System.in);
        int num1=input.nextInt();
        System.out.println("Enter the Second number");
//        Scanner input =new Scanner(Sysstem.in);
        int num2=input.nextInt();
        if (num1>num2){
            System.out.println("Number 1 is greatest");

        }
        else {
            System.out.println("Number 2 i greatest ");
        }




    }
}
