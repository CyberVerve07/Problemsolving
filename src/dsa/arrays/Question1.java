package dsa.arrays;

public class Question1 {
    static  double findAverage(int []arr) {
        double sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int size = arr.length;

        double avg = sum / size;
        return avg;
    }
        public static void main(String[] args) {
            //Find the average of the given array
            int[] arr = {1, 2, 3, 4};
            System.out.println(findAverage(arr));


    }
}
