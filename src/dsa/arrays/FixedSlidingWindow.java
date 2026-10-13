package dsa.arrays;

public class FixedSlidingWindow {
    public static int findMaxSumSubarray(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) {
            return 0;
        }

        int windowSum = 0;
        int maxSum = 0;

        // 1. Compute sum of the first window
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;

        // 2. Slide the window across the array
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k]; // Add incoming, subtract outgoing
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println("Maximum sum of subarray of size " + k + ": " + findMaxSumSubarray(arr, k));
        // Output: 9 (Subarray: [5, 1, 3])
    }
}
