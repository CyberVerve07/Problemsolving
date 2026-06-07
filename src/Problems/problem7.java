package Problems;

import java.util.Scanner;

public class problem7 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("Enter the first value");
        int num1= input.nextInt();
        System.out.println("Enter ");
        System.out.println("Enter the 2nd value");
        int num2= input.nextInt();
        System.out.println("Enter ");
        System.out.println("Enter the 3rd value");
        int num3= input.nextInt();
        if(num1>num2&&num2>num3) {
            System.out.println("The num 1 is greater " + num1);
            System.out.println("The number2 is greater" + num2);
        }
        else
            System.out.println("Thu number 3 is greater"+num3);






    }
}
