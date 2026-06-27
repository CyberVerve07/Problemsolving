package Array;

public class code9 {
    //code for find the min value of an array
    public static void main(String[] args) {


        int []arr = {10, 2, 3, 4, 6, 9, -1};
        int n = arr.length;
        int minValue = arr[0];
        // compare the values
        for (int i = 0; i <= n - 1; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
            }
        }
        System.out.println(minValue);
    }
}