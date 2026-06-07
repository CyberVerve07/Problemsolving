package Problems;

import java.util.Scanner;

public class Problem12 {
    public static void main(String[] args) {
        System.out.println("Entert the number");
        Scanner input=new Scanner(System.in);
        int num= input.nextInt();
        if (num>=0) {
            System.out.println("Number is postive");
        }
        else{
            System.out.println("Number is negative ");
        }
    }
}
