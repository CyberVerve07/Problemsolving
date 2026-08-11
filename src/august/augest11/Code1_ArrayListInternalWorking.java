package august.augest11;

import java.util.ArrayList;

/**
 * ----------------------------------------------------------------------------------
 * 📌 CODE 1: ArrayList Internal Working & Dynamic Resizing Architecture
 * ----------------------------------------------------------------------------------
 *
 * 🔍 HOW ARRAYLIST WORKS INTERNALLY IN JAVA:
 * 1. Underlying Data Structure:
 *    - ArrayList is backed by a resizable Object array (`transient Object[] elementData`).
 *
 * 2. Default Initial Capacity:
 *    - Default capacity is 10 (when elements are added for the first time if initialized with default constructor).
 *
 * 3. Dynamic Resizing Formula (Growth Rate = 50% / 1.5x):
 *    - `int newCapacity = oldCapacity + (oldCapacity >> 1);`
 *    - Example: 10 -> 15 -> 22 -> 33 -> 49 ...
 *
 * 4. Resizing Mechanics:
 *    - When capacity is full, a new larger array is created in heap memory.
 *    - Elements are copied from old array to new array using `Arrays.copyOf()` / `System.arraycopy()`.
 *    - Old array is garbage collected.
 *
 * ----------------------------------------------------------------------------------
 * ⏱️ TIME & SPACE COMPLEXITY ANALYSIS:
 * ----------------------------------------------------------------------------------
 * - `add(E e)` (at end):
 *     - Amortized Time Complexity: O(1) -> Adding element takes constant time on average.
 *     - Worst Case Time Complexity: O(N) -> When array is full and resizing/copying occurs.
 * - Memory / Space Complexity:
 *     - Space Complexity: O(N) where N is the number of elements.
 *     - Memory Overhead: Up to 50% unused array capacity after resizing.
 * ----------------------------------------------------------------------------------
 *
 * @author Aditya
 * @date 11th August
 */
public class Code1_ArrayListInternalWorking {

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("   DEMO 1: ARRAYLIST INTERNAL WORKING & DYNAMIC RESIZING   ");
        System.out.println("==========================================================\n");

        // Step 1: Initialize ArrayList (Internal array capacity is deferred until first element is added)
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Initial ArrayList created.");
        System.out.println("Initial Size (number of elements): " + numbers.size());
        System.out.println("Default Initial Internal Capacity: 10 (allocated on first add)\n");

        // Step 2: Adding 10 elements (Filling initial capacity)
        System.out.println("Adding 10 elements to fill default capacity (10)...");
        for (int i = 1; i <= 10; i++) {
            numbers.add(i * 10);
            System.out.println("Added: " + (i * 10) + " | Current Size: " + numbers.size());
        }

        System.out.println("\n--> Internal array capacity (10) is NOW FULL!");
        System.out.println("--> Next add() operation will trigger DYNAMIC RESIZING formula:");
        System.out.println("    newCapacity = oldCapacity + (oldCapacity >> 1) = 10 + 5 = 15");

        // Step 3: Triggering Resize by adding 11th element
        numbers.add(110);
        System.out.println("\nAdded 11th element (110) successfully!");
        System.out.println("New Size: " + numbers.size());
        System.out.println("New Internal Capacity: 15 slots");

        System.out.println("\nComplete ArrayList Elements: " + numbers);

        // Summary Table Printout
        printComplexitySummary();
    }

    private static void printComplexitySummary() {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("📊 TIME & SPACE COMPLEXITY SUMMARY (ArrayList.add)");
        System.out.println("----------------------------------------------------------");
        System.out.println("• Amortized Time Complexity : O(1) [Constant Time]");
        System.out.println("• Worst Case Time Complexity: O(N) [During Resize/Copy]");
        System.out.println("• Space Complexity          : O(N) [Contiguous Heap Array]");
        System.out.println("----------------------------------------------------------");
    }
}
