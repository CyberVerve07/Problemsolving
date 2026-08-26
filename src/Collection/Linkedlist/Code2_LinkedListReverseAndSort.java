package Collection.Linkedlist;

import java.util.Collections;
import java.util.LinkedList;

/**
 * ============================================================
 *  CODE 2 - REVERSING & SORTING LINKEDLIST USING COLLECTIONS
 *   Asked In: Amazon, Flipkart, Tech Mahindra, Mindtree
 *   Topic: Collections.reverse(), Collections.sort(), Comparators
 * ============================================================
 *
 * ============================================================
 *  TIME & SPACE COMPLEXITY ANALYSIS
 * ============================================================
 *  | Utility Method            | Time Complexity | Space Complexity |
 *  |---------------------------|-----------------|------------------|
 *  | Collections.reverse(list) | O(N)            | O(1)             |
 *  | Collections.sort(list)    | O(N log N)      | O(N) (TimSort)   |
 *  | Collections.swap(list,i,j)| O(N) index access| O(1)            |
 * ============================================================
 */
public class Code2_LinkedListReverseAndSort {

    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(45);
        numbers.add(12);
        numbers.add(89);
        numbers.add(3);
        numbers.add(27);

        System.out.println("=== REVERSE & SORT DEMO ===");
        System.out.println("Original List      : " + numbers);

        // 1. Reversing the LinkedList in-place - O(N)
        Collections.reverse(numbers);
        System.out.println("Reversed List : " + numbers);

        // 2. Sorting in Ascending Order - O(N log N) using TimSort
        Collections.sort(numbers);
        System.out.println("Sorted (Ascending) : " + numbers);

        // 3. Sorting in Descending Order using Custom Comparator - O(N log N)
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Sorted (Descending): " + numbers);

        // 4. Swapping elements at index 0 and last index - O(N)
        Collections.swap(numbers, 0, numbers.size() - 1);
        System.out.println("After Swapping     : " + numbers);
    }
}
