package dsa.arrays;

/**
 * ============================================================
 *  Q5 - MOVE ALL ZEROS TO END / SORT 0s 1s 2s (Dutch National Flag)
 *  🏢 Asked In: Microsoft, Amazon, Adobe, Snapdeal, OYO, Walmart
 *  ⭐ Difficulty: Medium
 *  📌 Topic: Two Pointer / Dutch National Flag Algorithm
 * ============================================================
 *
 *  PROBLEM A: Move All Zeros to End
 *  ----------------------------------
 *  Given an array, move all 0s to the end while maintaining
 *  the relative order of non-zero elements. Do it IN-PLACE.
 *
 *  Example:
 *    Input:  [0, 1, 0, 3, 12]
 *    Output: [1, 3, 12, 0, 0]
 *
 * ============================================================
 *  APPROACH - Two Pointer Method (O(n) Time, O(1) Space)
 * ============================================================
 *  Logic:
 *    - Use a pointer 'insertPos' starting at 0
 *    - Traverse array: if element is NOT zero → place it at insertPos++
 *    - After traversal → fill rest of array with 0s
 *
 *  DRY RUN:
 *    arr = [0, 1, 0, 3, 12]
 *    insertPos = 0
 *    ---
 *    i=0: 0   → skip
 *    i=1: 1   → arr[insertPos]=1, insertPos=1 → [1,1,0,3,12]
 *    i=2: 0   → skip
 *    i=3: 3   → arr[insertPos]=3, insertPos=2 → [1,3,0,3,12]
 *    i=4: 12  → arr[insertPos]=12, insertPos=3 → [1,3,12,3,12]
 *    Fill rest with 0: → [1,3,12,0,0] ✅
 *
 * ============================================================
 *  PROBLEM B: Sort Array of 0s, 1s, 2s
 *  ======================================
 *  🔥 DUTCH NATIONAL FLAG ALGORITHM (Asked heavily in MNCs!)
 *  ----------------------------------
 *  Given array containing only 0s, 1s, and 2s, sort it in O(n).
 *
 *  Example:
 *    Input:  [2, 0, 2, 1, 1, 0]
 *    Output: [0, 0, 1, 1, 2, 2]
 *
 *  Logic (3 Pointers: low, mid, high):
 *    - low  = start (all elements before low are 0)
 *    - mid  = current element
 *    - high = end (all elements after high are 2)
 *
 *    Rules while mid <= high:
 *      If arr[mid] == 0 → swap(arr[low], arr[mid]), low++, mid++
 *      If arr[mid] == 1 → mid++ (1 is already in correct position)
 *      If arr[mid] == 2 → swap(arr[mid], arr[high]), high-- (DON'T mid++)
 *
 *  DRY RUN:
 *    arr = [2, 0, 2, 1, 1, 0], low=0, mid=0, high=5
 *    ---
 *    arr[mid]=2 → swap(arr[0],arr[5]) → [0,0,2,1,1,2], high=4
 *    arr[mid]=0 → swap(arr[0],arr[0]) → [0,0,2,1,1,2], low=1, mid=1
 *    arr[mid]=0 → swap(arr[1],arr[1]) → [0,0,2,1,1,2], low=2, mid=2
 *    arr[mid]=2 → swap(arr[2],arr[4]) → [0,0,1,1,2,2], high=3
 *    arr[mid]=1 → mid=3
 *    arr[mid]=1 → mid=4 → mid > high → STOP
 *    Result: [0,0,1,1,2,2] ✅
 *
 * ============================================================
 */
public class Q5_ZerosAndDNF {

    // ✅ PROBLEM A: Move All Zeros to End - O(n) Time, O(1) Space
    public static void moveZerosToEnd(int[] arr) {
        int insertPos = 0; // Position for next non-zero element

        // Place all non-zero elements at the front
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[insertPos] = arr[i];
                insertPos++;
            }
        }

        // Fill remaining positions with 0
        while (insertPos < arr.length) {
            arr[insertPos] = 0;
            insertPos++;
        }
    }

    // ✅ PROBLEM B: Dutch National Flag - Sort 0s, 1s, 2s
    //              O(n) Time, O(1) Space - SINGLE PASS!
    public static void dutchNationalFlag(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                // Swap with low pointer (send 0 to front)
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // 1 is in correct place, just move mid
                mid++;
            } else {
                // arr[mid] == 2: Swap with high pointer (send 2 to end)
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--; // ⚠️ DON'T increment mid here! Check new arr[mid]
            }
        }
    }

    // Helper: print array
    public static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        System.out.println("=== MOVE ALL ZEROS TO END ===");
        int[] arr1 = {0, 1, 0, 3, 12};
        System.out.print("Before: "); print(arr1);
        moveZerosToEnd(arr1);
        System.out.print("After:  "); print(arr1);

        System.out.println("\n=== DUTCH NATIONAL FLAG ===");
        int[] arr2 = {2, 0, 2, 1, 1, 0};
        System.out.print("Before: "); print(arr2);
        dutchNationalFlag(arr2);
        System.out.print("After:  "); print(arr2);

        // More test cases
        System.out.println("\n=== ALL SAME ===");
        int[] arr3 = {1, 1, 1};
        dutchNationalFlag(arr3);
        print(arr3);

        /*
         * KEY INTERVIEW POINTS TO REMEMBER:
         * -----------------------------------
         * 1. Move Zeros: Use "insertPos" pointer pattern
         * 2. Dutch Flag: 3 pointers (low, mid, high)
         * 3. WHY don't we do mid++ when arr[mid]==2?
         *    → Because after swap, new arr[mid] is unknown and needs checking!
         * 4. Time: O(n), Space: O(1) → SINGLE PASS for DNF!
         * 5. This is named "Dutch National Flag" → Mention this in interviews!
         * 6. DNF is also used in: Quick Sort partition, 3-way partitioning
         */
    }
}
