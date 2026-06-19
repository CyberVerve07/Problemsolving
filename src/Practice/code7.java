package Practice;

import java.util.Scanner;

public class code7 {
    public static void main(String[] args) {
       System.out.println("Enter your budget");
        Scanner  input=new Scanner(System.in);
        int budget = input.nextInt();
        if (budget>=10000){
            System.out.println("Travell with Flight");
        } else if (budget>=5000) {
            System.out.println("Travell with Train");

        } else if (budget>=2000) {
            System.out.println("Travell with Bus:");

        }
        else {
            System.out.println("Dont Travell:");
        }
    }
}
