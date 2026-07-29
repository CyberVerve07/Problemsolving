package dsa.arrays;

import java.util.HashMap;

/**
 * ============================================================
 *  Q1 - TWO SUM
 *  🏢 Asked In: Amazon, Google, Microsoft, Flipkart, TCS, Infosys
 *  ⭐ Difficulty: Easy
 *  📌 Topic: Array + HashMap
 * ============================================================
 *
 *  PROBLEM:
 *  --------
 *  Given an array of integers 'nums' and an integer 'target',
 *  return the INDICES of the two numbers such that they add up to target.
 *
 *  Example:
 *    Input:  nums = [2, 7, 11, 15], target = 9
 *    Output: [0, 1]   → because nums[0] + nums[1] = 2 + 7 = 9
 *
 * ============================================================
 *  APPROACH 1 - BRUTE FORCE (O(n²) Time, O(1) Space)
 * ============================================================
 *  Logic:
 *    - Use two nested loops
 *    - Check every pair (i, j) where i != j
 *    - If nums[i] + nums[j] == target → return {i, j}
 *
 *  ❌ Not good for large inputs (TLE in interviews)
 *
 * ============================================================
 *  APPROACH 2 - OPTIMAL using HashMap (O(n) Time, O(n) Space)
 * ============================================================
 *  Logic:
 *    - For each number, calculate its "complement" = target - num
 *    - Check if complement already exists in the map
 *    - If YES → we found our pair → return indices
 *    - If NO  → store current number with its index in map
 *
 *  WHY HashMap?
 *    - HashMap gives O(1) lookup → we avoid the nested loop
 *    - We store: (number → index) as key-value pair
 *
 *  DRY RUN:
 *    nums = [2, 7, 11, 15], target = 9
 *    ---
 *    i=0: num=2, complement=9-2=7 → map is empty → store {2:0}
 *    i=1: num=7, complement=9-7=2 → 2 found in map at index 0 → return [0, 1] ✅
 *
 * ============================================================
 */
public class Q1_TwoSum {

    // ✅ OPTIMAL SOLUTION - O(n) Time
    public static int[] twoSum(int[] nums, int target) {
        // HashMap to store: number → its index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i]; // what we need to find

            if (map.containsKey(complement)) {
                // Found! Return both indices
                return new int[]{map.get(complement), i};
            }

            // Not found yet, store current number with index
            map.put(nums[i], i);
        }

        return new int[]{}; // No solution found
    }

    // ❌ BRUTE FORCE - O(n²) Time
    public static int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        System.out.println("=== TWO SUM ===");

        // Optimal Solution
        int[] result = twoSum(nums, target);
        System.out.println("Optimal  → Indices: [" + result[0] + ", " + result[1] + "]");

        // Brute Force
        int[] result2 = twoSumBrute(nums, target);
        System.out.println("Brute    → Indices: [" + result2[0] + ", " + result2[1] + "]");

        // Edge case
        int[] nums2 = {3, 2, 4};
        int[] r3 = twoSum(nums2, 6);
        System.out.println("Test 2   → Indices: [" + r3[0] + ", " + r3[1] + "]");

        /*
         * KEY INTERVIEW POINTS TO REMEMBER:
         * -----------------------------------
         * 1. Always mention brute force first, then optimize
         * 2. HashMap lookup is O(1) average case
         * 3. Ask: "Can there be duplicate numbers?" → HashMap handles it
         * 4. Ask: "Is there exactly one solution?" → Important edge case
         * 5. Time: O(n), Space: O(n)
         */
    }
}
