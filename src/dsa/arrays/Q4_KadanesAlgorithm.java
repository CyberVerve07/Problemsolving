package dsa.arrays;

/**
 * ============================================================
 *  Q4 - KADANE'S ALGORITHM (Maximum Subarray Sum)
 *  ðŸ¢ Asked In: Amazon, Microsoft, Google, Adobe, Paytm, Flipkart
 *  â­ Difficulty: Medium
 *  ðŸ“Œ Topic: Dynamic Programming / Greedy
 * ============================================================
 *
 *  PROBLEM:
 *  --------
 *  Given an integer array nums, find the CONTIGUOUS SUBARRAY
 *  which has the largest sum and return its sum.
 *
 *  Example:
 *    Input:  nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *    Output: 6
 *    Explanation: [4, -1, 2, 1] has the largest sum = 6
 *
 * ============================================================
 *  APPROACH 1 - BRUTE FORCE (O(nÂ²) or O(nÂ³))
 * ============================================================
 *  Logic:
 *    - Check sum of every possible subarray using nested loops
 *    - Track maximum sum found
 *  âŒ O(nÂ³) â†’ way too slow for interviews
 *
 * ============================================================
 *  APPROACH 2 - KADANE'S ALGORITHM (O(n) Time, O(1) Space)
 * ============================================================
 *
 *  Core Idea (The KEY insight):
 *  ----------------------------
 *  â†’ If current sum becomes NEGATIVE, discard it and START FRESH.
 *  â†’ A negative sum will always REDUCE the next element.
 *  â†’ So it's better to start a new subarray from the next element.
 *
 *  Variables:
 *    - currentSum = sum of current subarray being considered
 *    - maxSum = maximum sum found so far (our answer)
 *
 *  DRY RUN:
 *    nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *    Start: currentSum=0, maxSum=Integer.MIN_VALUE
 *    ---
 *    i=0: num=-2 â†’ cur=-2,     max=-2
 *    i=1: num= 1 â†’ cur=-2+1=-1 < 0? No â†’ cur=-1, max=-1... wait:
 *         Actually cur = max(1, -2+1) = 1 â†’ cur=1, max=1
 *    i=2: num=-3 â†’ cur=1-3=-2, max=1
 *    i=3: num= 4 â†’ cur=-2+4=2 > 0, OR start fresh: 4 > 2 â†’ cur=4, max=4
 *    i=4: num=-1 â†’ cur=4-1=3, max=4
 *    i=5: num= 2 â†’ cur=3+2=5, max=5
 *    i=6: num= 1 â†’ cur=5+1=6, max=6 
 *    i=7: num=-5 â†’ cur=6-5=1, max=6
 *    i=8: num= 4 â†’ cur=1+4=5, max=6
 *    Final maxSum = 6 
 *
 *  SIMPLE RULE: if (currentSum < 0) â†’ reset currentSum = 0
 *
 * ============================================================
 */
public class Q4_KadanesAlgorithm {

    //  KADANE'S ALGORITHM - O(n) Time, O(1) Space
    public static int maxSubarraySum(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE; // Handles all-negative arrays too

        for (int num : nums) {
            currentSum += num;

            // Update max if currentSum is greater
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            // KEY STEP: If sum is negative, reset it (start fresh)
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    //  BONUS: Also return the actual subarray (Common follow-up!)
    public static void maxSubarrayWithIndices(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart; // Update start
                end = i;           // Update end
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1; // Next element is new potential start
            }
        }

        System.out.print("Max Subarray = [");
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i]);
            if (i < end) System.out.print(", ");
        }
        System.out.println("] â†’ Sum = " + maxSum);
    }

    //  BRUTE FORCE - O(nÂ²) Time
    public static int maxSubarrayBrute(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("=== KADANE'S ALGORITHM ===");

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: [-2,1,-3,4,-1,2,1,-5,4]");
        System.out.println("Max Sum (Kadane's) = " + maxSubarraySum(nums1));
        System.out.println("Max Sum (Brute)    = " + maxSubarrayBrute(nums1));

        System.out.println("\n=== WITH SUBARRAY INDICES ===");
        maxSubarrayWithIndices(nums1);

        // All negative
        System.out.println("\n=== ALL NEGATIVE NUMBERS ===");
        int[] nums2 = {-3, -1, -2};
        System.out.println("Max Sum = " + maxSubarraySum(nums2)); // Should be -1

        /*
         * KEY INTERVIEW POINTS TO REMEMBER:
         * -----------------------------------
         * 1. MEMORIZE: "If currentSum < 0, reset to 0"
         * 2. Use Integer.MIN_VALUE for maxSum (handles all-negative arrays)
         * 3. Time: O(n), Space: O(1) â†’ Optimal!
         * 4. Named "Kadane's Algorithm" â†’ Say the name in interviews!
         * 5. FOLLOW-UP: "Print the actual subarray" â†’ track start/end indices
         * 6. This is a GREEDY + DP approach
         */
    }
}
