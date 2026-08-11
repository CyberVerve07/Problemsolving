package august.augest11;

import java.util.ArrayList;

/**
 * ----------------------------------------------------------------------------------
 * 📌 CODE 4: ArrayList Performance Optimization: ensureCapacity() & trimToSize()
 * ----------------------------------------------------------------------------------
 *
 * 🔍 PERFORMANCE OPTIMIZATION STRATEGIES:
 * 1. `ensureCapacity(int minCapacity)`:
 *    - Problem: Adding millions of elements causes multiple array allocations (10 -> 15 -> 22 -> 33 -> ...).
 *    - Solution: Pre-allocate capacity in a single step to eliminate resize & copy overhead!
 *    - Time Saving: Huge performance gain for large data insertion.
 *
 * 2. `trimToSize()`:
 *    - Problem: An ArrayList with size 1,000 might have an internal capacity of 1,500 slots (500 wasted slots!).
 *    - Solution: `trimToSize()` creates a new array of exact size 1,000 and releases unused 500 slots to GC.
 *    - Space Saving: Reduces memory footprint in memory-constrained environments.
 *
 * ----------------------------------------------------------------------------------
 * ⏱️ TIME & SPACE COMPLEXITY ANALYSIS:
 * ----------------------------------------------------------------------------------
 * - Default Bulk Additions   : Amortized O(1) per add, but involves Log1.5(N) expensive array copy operations.
 * - Optimized Bulk Additions : Pure O(1) per add (Zero array re-allocations).
 * - `trimToSize()`           : O(N) Time (Array copy operation), but reclaims O(Capacity - Size) Space!
 * ----------------------------------------------------------------------------------
 *
 * @author Aditya
 * @date 11th August
 */
public class Code4_ArrayListCapacityManagement {

    private static final int NUM_ELEMENTS = 5_000_000;

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("   DEMO 4: ARRAYLIST CAPACITY OPTIMIZATION BENCHMARK      ");
        System.out.println("==========================================================\n");

        // -------------------------------------------------------------------
        // Test 1: Without pre-allocating capacity (Default incremental resizes)
        // -------------------------------------------------------------------
        System.out.println("1. Running Test WITHOUT ensureCapacity() [" + NUM_ELEMENTS + " insertions]...");
        long startTime = System.currentTimeMillis();

        ArrayList<Integer> listWithoutCapacity = new ArrayList<>();
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            listWithoutCapacity.add(i);
        }

        long endTime = System.currentTimeMillis();
        long durationWithoutCapacity = endTime - startTime;
        System.out.println("   --> Time Taken WITHOUT pre-allocation: " + durationWithoutCapacity + " ms");

        // -------------------------------------------------------------------
        // Test 2: WITH ensureCapacity() pre-allocated
        // -------------------------------------------------------------------
        System.out.println("\n2. Running Test WITH ensureCapacity(" + NUM_ELEMENTS + ")...");
        startTime = System.currentTimeMillis();

        ArrayList<Integer> listWithCapacity = new ArrayList<>();
        listWithCapacity.ensureCapacity(NUM_ELEMENTS); // Single allocation!
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            listWithCapacity.add(i);
        }

        endTime = System.currentTimeMillis();
        long durationWithCapacity = endTime - startTime;
        System.out.println("   --> Time Taken WITH pre-allocation   : " + durationWithCapacity + " ms");

        double speedup = (double) durationWithoutCapacity / (durationWithCapacity == 0 ? 1 : durationWithCapacity);
        System.out.printf("   🚀 PERFORMANCE GAIN: %.2fx Faster!\n", speedup);

        // -------------------------------------------------------------------
        // Test 3: Reclaiming Wasted Memory with trimToSize()
        // -------------------------------------------------------------------
        System.out.println("\n3. Demonstrating trimToSize() Memory Reclamation...");
        ArrayList<String> memoryList = new ArrayList<>(1000); // Capacity = 1000
        memoryList.add("Item 1");
        memoryList.add("Item 2");
        memoryList.add("Item 3");

        System.out.println("   Current Size: " + memoryList.size() + " | Internal Capacity: ~1000");
        System.out.println("   --> Trimming unused slots...");
        memoryList.trimToSize(); // Trims array capacity down to size (3)
        System.out.println("   --> trimToSize() executed! Capacity is now trimmed exactly to Size: " + memoryList.size());

        printOptimizationSummary();
    }

    private static void printOptimizationSummary() {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("📊 SUMMARY & BEST PRACTICES FOR ARRAYLIST CAPACITY");
        System.out.println("----------------------------------------------------------");
        System.out.println("1. Use `new ArrayList<>(initialCapacity)` or `ensureCapacity()` when");
        System.out.println("   you know expected number of elements in advance.");
        System.out.println("   --> Reduces GC pressure & removes array copy operations.");
        System.out.println("2. Use `trimToSize()` after bulk removals to free unused heap memory.");
        System.out.println("----------------------------------------------------------");
    }
}
