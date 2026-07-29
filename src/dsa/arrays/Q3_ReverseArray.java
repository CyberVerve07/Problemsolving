package dsa.arrays;

/**
 * ============================================================
 *  Q3 - REVERSE AN ARRAY
 *  🏢 Asked In: TCS, Infosys, Wipro, Capgemini, Cognizant, HCL
 *  ⭐ Difficulty: Easy
 *  📌 Topic: Two Pointer Technique
 * ============================================================
 *
 *  PROBLEM:
 *  --------
 *  Given an array, reverse it in-place (without using extra array).
 *
 *  Example:
 *    Input:  arr = [1, 2, 3, 4, 5]
 *    Output: arr = [5, 4, 3, 2, 1]
 *
 * ============================================================
 *  APPROACH 1 - BRUTE FORCE (Extra Array) - O(n) Time, O(n) Space
 * ============================================================
 *  Logic:
 *    - Create a new array
 *    - Fill it from end to start of original array
 *  ❌ Uses extra space O(n) → interviewer will ask for in-place solution
 *
 * ============================================================
 *  APPROACH 2 - TWO POINTER (In-place) - O(n) Time, O(1) Space
 * ============================================================
 *  Logic:
 *    - Use two pointers: left = 0, right = arr.length - 1
 *    - Swap arr[left] and arr[right]
 *    - Move left → (left++) and right ← (right--)
 *    - Continue until left >= right
 *
 *  DRY RUN:
 *    arr = [1, 2, 3, 4, 5]
 *    ---
 *    Step 1: left=0, right=4 → swap(1,5) → [5, 2, 3, 4, 1]
 *    Step 2: left=1, right=3 → swap(2,4) → [5, 4, 3, 2, 1]
 *    Step 3: left=2, right=2 → left >= right → STOP
 *    Result: [5, 4, 3, 2, 1] ✅
 *
 * ============================================================
 *
 *  🔥 THIS "TWO POINTER" TECHNIQUE IS THE BASE OF MANY PROBLEMS:
 *     → Palindrome check
 *     → Container with most water
 *     → 3Sum, 4Sum problems
 *  LEARN THIS PATTERN WELL!
 *
 * ============================================================
 */
public class Q3_ReverseArray {

    // ✅ OPTIMAL SOLUTION - Two Pointer - O(n) Time, O(1) Space
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap arr[left] and arr[right]
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move pointers towards center
            left++;
            right--;
        }
    }

    // ❌ BRUTE FORCE using extra array - O(n) Space
    public static int[] reverseArrayBrute(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            result[arr.length - 1 - i] = arr[i];
        }
        return result;
    }

    // Helper method to print array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println("=== REVERSE AN ARRAY ===");

        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.print("Original: ");
        printArray(arr1);

        reverseArray(arr1);
        System.out.print("Reversed: ");
        printArray(arr1);

        // Odd length array
        System.out.println("\n=== ODD LENGTH ARRAY ===");
        int[] arr2 = {10, 20, 30};
        System.out.print("Original: ");
        printArray(arr2);
        reverseArray(arr2);
        System.out.print("Reversed: ");
        printArray(arr2);

        // Single element
        System.out.println("\n=== SINGLE ELEMENT ===");
        int[] arr3 = {99};
        reverseArray(arr3);
        printArray(arr3);

        /*
         * KEY INTERVIEW POINTS TO REMEMBER:
         * -----------------------------------
         * 1. Always say: "I will use Two Pointer technique"
         * 2. Swap using temp variable (or XOR swap if asked)
         * 3. In-place means O(1) extra space
         * 4. Time: O(n), Space: O(1)
         * 5. FOLLOW-UP: "Reverse without temp variable?" → Use XOR:
         *    arr[l] = arr[l] ^ arr[r];
         *    arr[r] = arr[l] ^ arr[r];
         *    arr[l] = arr[l] ^ arr[r];
         */
    }
}
