package loops;

import java.util.Scanner;

public class Code08 {
    public static void main(String[] args) {
//User se number lo.
//
//Uska table print karo.
//
//Input:
        System.out.println("Enter the number ");
        Scanner input=new Scanner(System.in);
        int num= input.nextInt();
        for (int i=1;i<=10;i++){
            System.out.println(num + " x " + i + " = " + (num * i));
        }
        }
}
