package array;

import java.util.Scanner;

public class Code02 {
    public static void main(String[] args) {
        //taking input from array
        int []arr=new int[3];
        Scanner input=new Scanner(System.in);
        int n=arr.length;
        for (int i=0;i<=n-1;i++){
            System.out.println("Provide input for index"+i);
            arr[i] = input.nextInt();
    }
        for (int val:arr){
            System.out.println(val);
        }
}}
