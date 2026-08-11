package august.augest8;

import java.util.Scanner;

public class Demo12 {
    public static void main(String[] args) {

        try {
            int [] arr = new int[]{10,20,30,40,50};

            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the index of the element you want to access:");
              int index=sc.nextInt();
              System.out.println(arr[index]);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
