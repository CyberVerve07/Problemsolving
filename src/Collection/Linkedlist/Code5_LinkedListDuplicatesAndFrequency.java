package Collections.Linkedlist;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;

/**
 * ============================================================
 *  CODE 5 - FREQUENCY COUNT & DUPLICATE REMOVAL IN LINKEDLIST
 *  🏢 Asked In: HCL, Wipro, Cognizant, TCS, Capgemini
 *  ⭐ Topic: Collections Utilities + LinkedHashSet Integration
 * ============================================================
 *
 * ============================================================
 *  TIME & SPACE COMPLEXITY ANALYSIS
 * ============================================================
 *  | Task                       | Time Complexity | Space Complexity |
 *  |----------------------------|-----------------|------------------|
 *  | Collections.frequency()    | O(N)            | O(1)             |
 *  | Duplicate Removal (HashSet)| O(N)            | O(N)             |
 *  | Collections.min() / max()  | O(N)            | O(1)             |
 * ============================================================
 */
public class Code5_LinkedListDuplicatesAndFrequency {

    public static void main(String[] args) {
        LinkedList<String> items = new LinkedList<>();
        items.add("Apple");
        items.add("Banana");
        items.add("Apple");
        items.add("Orange");
        items.add("Banana");
        items.add("Apple");

        System.out.println("=== 1. FREQUENCY COUNT ===");
        System.out.println("Items List: " + items);
        int appleCount = Collections.frequency(items, "Apple"); // O(N)
        System.out.println("Frequency of 'Apple': " + appleCount);

        System.out.println("\n=== 2. REMOVING DUPLICATES (MAINTAINING ORDER) ===");
        // LinkedHashSet preserves insertion order while eliminating duplicates - O(N)
        LinkedHashSet<String> uniqueSet = new LinkedHashSet<>(items);
        LinkedList<String> uniqueList = new LinkedList<>(uniqueSet);
        System.out.println("List Without Duplicates: " + uniqueList);


        System.out.println("\n=== 3. MIN AND MAX ELEMENTS ===");
        String minItem = Collections.min(uniqueList); // Lexicographical min - O(N)
        String maxItem = Collections.max(uniqueList); // Lexicographical max - O(N)
        System.out.println("Min Element: " + minItem + " | Max Element: " + maxItem);
    }
}
