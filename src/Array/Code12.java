package Array;

public class Code12 {
    public static void main(String[] args) {

        //Access the values of the array :

        int[] arr = {10, 20, 30};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            System.out.println(sum);
        }
    }
}