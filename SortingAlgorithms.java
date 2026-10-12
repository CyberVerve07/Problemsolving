import java.util.Arrays;

/**
 * ============================================================
 *  DSA - Sorting Algorithms in Java
 *  Covers: Merge Sort | Quick Sort | Heap Sort
 *  Time Complexities:
 *    - Merge Sort  : O(n log n) - All cases
 *    - Quick Sort  : O(n log n) avg, O(n²) worst
 *    - Heap Sort   : O(n log n) - All cases
 * ============================================================
 */
public class SortingAlgorithms {

    // =========================================================
    // 1. MERGE SORT - Divide & Conquer
    //    Stable Sort | Extra Space: O(n)
    // =========================================================

    /**
     * Splits array into halves, sorts each half, then merges them.
     */
    static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return; // Base case: single element

        int mid = left + (right - left) / 2; // Avoid integer overflow

        mergeSort(arr, left, mid);        // Sort left half
        mergeSort(arr, mid + 1, right);   // Sort right half
        merge(arr, left, mid, right);     // Merge both halves
    }

    /**
     * Merges two sorted subarrays: arr[left..mid] and arr[mid+1..right]
     */
    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data into temp arrays
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        // Merge temp arrays back
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // =========================================================
    // 2. QUICK SORT - Divide & Conquer
    //    In-place Sort | Extra Space: O(log n) stack
    // =========================================================

    /**
     * Picks a pivot, partitions array around it, and recursively sorts.
     */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);   // Sort left of pivot
            quickSort(arr, pivotIndex + 1, high);  // Sort right of pivot
        }
    }

    /**
     * Lomuto Partition Scheme:
     * Places pivot at its correct position and returns its index.
     */
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int i = low - 1;       // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return pivot index
    }

    // =========================================================
    // 3. HEAP SORT - Uses Binary Heap
    //    In-place Sort | Extra Space: O(1)
    // =========================================================

    /**
     * Builds a max-heap, then extracts elements one by one.
     */
    static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build Max-Heap (heapify from last non-leaf to root)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root (max) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    /**
     * Heapify subtree rooted at index 'i' in array of size 'n'.
     * Ensures max-heap property: parent >= children
     */
    static void heapify(int[] arr, int n, int i) {
        int largest = i;          // Assume root is largest
        int left    = 2 * i + 1; // Left child index
        int right   = 2 * i + 2; // Right child index

        // Check if left child is larger
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right child is larger
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest); // Recursively heapify affected subtree
        }
    }

    // =========================================================
    // UTILITY - Print Array
    // =========================================================
    static void printArray(int[] arr, String label) {
        System.out.print(label + ": ");
        System.out.println(Arrays.toString(arr));
    }

    // =========================================================
    // MAIN - Test All Sorting Algorithms
    // =========================================================
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   DSA - Sorting Algorithms in Java   ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        // ── Merge Sort ──────────────────────────────
        int[] arr1 = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("▶ MERGE SORT");
        printArray(arr1, "  Before");
        mergeSort(arr1, 0, arr1.length - 1);
        printArray(arr1, "  After ");
        System.out.println("  Time Complexity : O(n log n) | Space: O(n)\n");

        // ── Quick Sort ──────────────────────────────
        int[] arr2 = {64, 25, 12, 22, 11};
        System.out.println("▶ QUICK SORT");
        printArray(arr2, "  Before");
        quickSort(arr2, 0, arr2.length - 1);
        printArray(arr2, "  After ");
        System.out.println("  Time Complexity : O(n log n) avg | Space: O(log n)\n");

        // ── Heap Sort ───────────────────────────────
        int[] arr3 = {12, 11, 13, 5, 6, 7};
        System.out.println("▶ HEAP SORT");
        printArray(arr3, "  Before");
        heapSort(arr3);
        printArray(arr3, "  After ");
        System.out.println("  Time Complexity : O(n log n) | Space: O(1)\n");

        // ── Summary Table ───────────────────────────
        System.out.println("╔══════════════╦═══════════════╦═══════════════╦═══════════════╦═══════════╗");
        System.out.println("║  Algorithm   ║   Best Case   ║ Average Case  ║  Worst Case   ║   Space   ║");
        System.out.println("╠══════════════╬═══════════════╬═══════════════╬═══════════════╬═══════════╣");
        System.out.println("║  Merge Sort  ║  O(n log n)   ║  O(n log n)   ║  O(n log n)   ║   O(n)    ║");
        System.out.println("║  Quick Sort  ║  O(n log n)   ║  O(n log n)   ║    O(n²)      ║ O(log n)  ║");
        System.out.println("║  Heap Sort   ║  O(n log n)   ║  O(n log n)   ║  O(n log n)   ║   O(1)    ║");
        System.out.println("╚══════════════╩═══════════════╩═══════════════╩═══════════════╩═══════════╝");
    }
}
