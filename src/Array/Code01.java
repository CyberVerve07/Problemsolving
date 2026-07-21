package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Code01 {
    public static void main(String[] args) {
         int []arr={10,20,3};
//        System.out.println(arr.length );
        for (int val:arr){
            System.out.println(val);
            //taking input from array
            Scanner input=new Scanner(System.in);
            arr[val]= input.nextInt();
        }
//        System.out.println(i);
    }
}
