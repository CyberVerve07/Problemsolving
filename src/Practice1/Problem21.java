package Practice1;

import java.util.Scanner;

public class Problem21 {
    //Scanner se age lo.
    //
    //age >= 18 → Eligible
    //warna Not Eligible
    public static void main(String[] args) {
        System.out.println("Enter you age ");
        Scanner input=new Scanner(System.in);
        int age= input.nextInt();
        if (age>=18){
            System.out.println("You are eligible for vote");
        }
        else {
            System.out.println("You are not eligible for vote ");
        }
    }
}
