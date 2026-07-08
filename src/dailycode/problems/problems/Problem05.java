package dailycode.problems.problems;

import java.util.Scanner;

public class Problem05 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the marks of English");
        int marks1= input.nextInt();
        System.out.println("Enter the marks of Computer");
        int marks2= input.nextInt();
        System.out.println("Enter the marks of Hindi ");
        int marks3= input.nextInt();
         int total;
         float percentage ;

         total=marks1+marks2+marks3;
        System.out.println("The total is "+total);
        percentage=total/3;

        System.out.println("The percentage is :"+percentage);
    }
}
