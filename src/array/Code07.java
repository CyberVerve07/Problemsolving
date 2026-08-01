package array;
//code for multiplication of array

public class Code07 {
    public static void main(String[] args) {
        //multiplication of array
        int[] arr = {5,5,5,5,5,};
        int n = arr.length;
        int mul = 1;
        //code for multiplication of elements of an array
        for (int i = 0; i <= n - 1; i++){
            int val=arr[i];
            mul=mul*val;
            System.out.println(mul);

        }
}}
