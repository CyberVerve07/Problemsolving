package Practice;

import java.util.Scanner;

public class code10 {
    //print greatest anong 3 num
    static void number(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first number");
        int num1= sc.nextInt();;
        System.out.println("Enter second number");
        int num2= sc.nextInt();
        System.out.println("Enter third number");
        int num3= sc.nextInt();
        if ((num1 >= num2) && (num1 >= num3)){
            System.out.println("Number1 is Greater");
        } else if (num2>=num1 && num2>num3) {
            System.out.println("Number 2 is Greater");

        }
        else {
            System.out.println("Number 3 is Greater");
        }

    }

    public static void main(String[] args) {
        number();
    }
}
