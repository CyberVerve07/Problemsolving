package dailycode.problems.problems;

import java.util.Scanner;

public class Problem03 {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        System.out.println("Enter the Length ");
        float length= input.nextFloat();
        System.out.println("Enter the breadth");
        float breadth= input.nextFloat();
        float area;
        area=(length*breadth);
        System.out.println("The area of the rectangle is "+area);
        input.close();
    }
}

