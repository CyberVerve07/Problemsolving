package dailycode.problems.practice1;

import java.util.Scanner;

public class Problem20 {
    //Scanner se ek number lo.
    //Agar even hai to "Even" print karo, warna "Odd".
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner input=new Scanner(System.in);
        int num= input.nextInt();
        if (num %2==0){
            System.out.println("Number is even");
        }
        else {
            System.out.println( "Number is Odd");
        }
    }


}
