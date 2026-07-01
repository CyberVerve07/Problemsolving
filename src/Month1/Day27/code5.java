package Day27;
import java.util.Arrays;

    //Write a program that takes an array of strings (e.g., {"apple", "banana", "cherry"}) and
    // reverses its order strictly in-place. You are not allowed to
    // create a secondary array to hold the reversed values.


    class Code5 {
        public static void main(String[] args) {
            String[] fruits = {"apple", "banana", "cherry", "date", "elderberry"};

            System.out.println("Original: " + Arrays.toString(fruits));

            int start = 0;
            int end = fruits.length - 1;

            // Process the reversal in-place
            while (start < end) {
                // Swap logic using a temporary variable
                String temp = fruits[start];
                fruits[start] = fruits[end];
                fruits[end] = temp;

                // Move pointers toward the center
                start++;
                end--;
            }

            System.out.println("Reversed: " + Arrays.toString(fruits));
        }
    }