package Problems;

import java.util.Scanner;

public class PRoblem9 {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner input=new Scanner(System.in);
        int num = input.nextInt();
//        System.out.println("Enter the number");
        if (num<=0){
            System.out.println("Number is negtive "+num);

        }
        else {
            System.out.println("Number is postive ");
        }
    }
}
