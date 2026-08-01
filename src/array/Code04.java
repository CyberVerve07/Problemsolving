package array;

import java.util.Scanner;

public class Code04 {
    public static void main(String[] args) {
//        int [] arr={10,20,30,40};
//        System.out.println(arr[2]);//accessing value of an array :
//        for(int val:arr){
//            System.out.println(val);//using for each loop printing the values of array

            //taking input from array
        int arr[]=new int[5];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the element of an array : ");
        int n=arr.length;
        for (int i=0;i<=n-1;i++){
            arr[i]= sc.nextInt();
        }
//verify using for each loop
        for (int val:arr){
            System.out.println(val);
        }
        }
    }

