package dsa.arrays;

/**
 * ============================================================
 *  Q2 - FIND MAXIMUM AND MINIMUM IN ARRAY
 *  🏢 Asked In: TCS, Wipro, Infosys, Capgemini, Accenture, HCL
 *  ⭐ Difficulty: Easy
 *  📌 Topic: Array Traversal
 * ============================================================
 *
 *  PROBLEM:
 *  --------
 *  Given an array of integers, find the maximum and minimum element.
 *
 *  Example:
 *    Input:  arr = [3, 5, 4, 1, 9]
 *    Output: Max = 9, Min = 1
 *
 * ============================================================
 *  APPROACH 1 - BRUTE FORCE using Sorting (O(n log n) Time)
 * ============================================================
 *  Logic:
 *    - Sort the array
 *    - First element = Min, Last element = Max
 *  ❌ Sorting changes original array and takes extra time
 *
 * ============================================================
 *  APPROACH 2 - OPTIMAL Single Traversal (O(n) Time, O(1) Space)
 * ============================================================
 *  Logic:
 *    - Initialize max = arr[0], min = arr[0]
 *    - Traverse the array from index 1
 *    - If current > max → update max
 *    - If current < min → update min
 *
 *  DRY RUN:
 *    arr = [3, 5, 4, 1, 9]
 *    Start: max=3, min=3
 *    ---
 *    i=1: val=5 → 5>3 → max=5
 *    i=2: val=4 → no change
 *    i=3: val=1 → 1<3 → min=1
 *    i=4: val=9 → 9>5 → max=9
 *    Result: max=9, min=1 ✅
 *
 * ============================================================
 */
public class Q2_MaxAndMin {

    // ✅ OPTIMAL SOLUTION - O(n) Time, O(1) Space
    public static void findMaxMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty!");
            return;
        }

        int max = arr[0]; // Assume first element is max
        int min = arr[0]; // Assume first element is min

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // Update max if current is greater
            }
            if (arr[i] < min) {
                min = arr[i]; // Update min if current is smaller
            }
        }

        System.out.println("Maximum = " + max);
        System.out.println("Minimum = " + min);
    }

    // ============================================================
    //  BONUS VARIANT: Find Second Largest (Also Very Common!)
    //  🏢 Asked In: Amazon, Infosys, Wipro
    // ============================================================
    public static int findSecondLargest(int[] arr) {
        int first = Integer.MIN_VALUE;  // Largest
        int second = Integer.MIN_VALUE; // Second Largest

        for (int num : arr) {
            if (num > first) {
                second = first; // Old first becomes second
                first = num;    // Update first
            } else if (num > second && num != first) {
                second = num;   // Update second if it's smaller than first but bigger than current second
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 9};

        System.out.println("=== MAX AND MIN IN ARRAY ===");
        findMaxMin(arr);

        System.out.println("\n=== SECOND LARGEST ===");
        int secondLargest = findSecondLargest(arr);
        System.out.println("Second Largest = " + secondLargest);

        // Edge Cases
        System.out.println("\n=== EDGE CASE: Single Element ===");
        int[] single = {42};
        findMaxMin(single);

        /*
         * KEY INTERVIEW POINTS TO REMEMBER:
         * -----------------------------------
         * 1. Always ask: "Are there duplicates?" → affects second largest logic
         * 2. Always ask: "Can array be null or empty?" → handle edge case
         * 3. Use Integer.MIN_VALUE and Integer.MAX_VALUE for initialization
         * 4. Time: O(n), Space: O(1) → this is already optimal
         * 5. Second Largest is a very common follow-up question!
         */
    }
}
