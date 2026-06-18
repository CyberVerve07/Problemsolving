package Practice1;

import java.util.Scanner;

public class Problem23 {
    public static void main(String[] args) {

        //Scanner se ek number lo aur uska table print karo.
        System.out.println("Enter the number");
        Scanner input=new Scanner(System.in);
        int num= input.nextInt();
        for (int i=1;i<=10;i++) {
            System.out.println("The multiplication table of number is :"+i * num);
        }
    }
}
