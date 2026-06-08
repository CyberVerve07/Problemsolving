package Problems;

import java.util.Scanner;

public class Problem21 {
    public static void main(String[] args) {
        System.out.println("Enter the day ");
        Scanner input=new Scanner(System.in);
        int day= input.nextInt();
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuestday");
                break;
            case 3:
                System.out.println("Wenestday");
                break;
            case 4:
                System.out.println("Thurstday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday:");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("invalid day number");
        }

    }
}
