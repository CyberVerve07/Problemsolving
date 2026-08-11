package august.augest11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * ----------------------------------------------------------------------------------
 * 📌 CODE 3: ArrayList Iteration Techniques, Safe Removal & Search Operations
 * ----------------------------------------------------------------------------------
 *
 * 🔍 ITERATION TECHNIQUES & CONCURRENCY TRAPS:
 * 1. Traditional `for` loop  : Index-based iteration. Fast & simple.
 * 2. Enhanced `for-each` loop: Syntactic sugar for Iterator.
 *                              ⚠️ TRAP: Modifying list during for-each throws `ConcurrentModificationException`!
 * 3. `Iterator`              : Forward traversal with SAFE element deletion (`iterator.remove()`).
 * 4. `ListIterator`          : Bidirectional traversal (forward & backward) + add/set during iteration.
 * 5. `forEach` with Lambda   : Modern functional programming approach (Java 8+).
 *
 * ----------------------------------------------------------------------------------
 * ⏱️ TIME & SPACE COMPLEXITY ANALYSIS:
 * ----------------------------------------------------------------------------------
 * - Iteration (all techniques) : O(N) Time -> Visits all N elements once.
 * - Search (`contains`, `indexOf`): O(N) Time -> Performs linear scan over internal array.
 * - Auxiliary Space            : O(1) for standard iterators.
 * ----------------------------------------------------------------------------------
 *
 * @author Aditya
 * @date 11th August
 */
public class Code3_ArrayListIterationAndSearch {

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("   DEMO 3: ARRAYLIST ITERATION, SAFE REMOVAL & SEARCH     ");
        System.out.println("==========================================================\n");

        List<String> techStack = new ArrayList<>();
        techStack.add("Java");
        techStack.add("Python");
        techStack.add("C++");
        techStack.add("JavaScript");
        techStack.add("Go");
        techStack.add("Java"); // Duplicate for testing lastIndexOf

        System.out.println("Tech Stack List: " + techStack + "\n");

        // 1. Searching Operations [O(N) Time]
        System.out.println("--- 1. Search Operations [O(N) Linear Search Time] ---");
        System.out.println("contains('Python') : " + techStack.contains("Python"));
        System.out.println("indexOf('Java')    : " + techStack.indexOf("Java") + " (First Occurrence)");
        System.out.println("lastIndexOf('Java'): " + techStack.lastIndexOf("Java") + " (Last Occurrence)");
        System.out.println("contains('Rust')   : " + techStack.contains("Rust"));

        // 2. Safe Element Removal using Iterator.remove() [O(N) Time]
        System.out.println("\n--- 2. Safe Removal using Iterator (Avoids ConcurrentModificationException) ---");
        System.out.println("Removing 'C++' safely during iteration...");
        Iterator<String> iterator = techStack.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("C++".equals(item)) {
                iterator.remove(); // SAFE! Updates modCount internally
                System.out.println("--> Successfully removed 'C++' using iterator.remove()");
            }
        }
        System.out.println("List after Iterator Removal: " + techStack);

        // 3. Bidirectional Traversal using ListIterator [O(N) Time]
        System.out.println("\n--- 3. Bidirectional Traversal using ListIterator ---");
        ListIterator<String> listIterator = techStack.listIterator();
        
        System.out.print("Forward Traversal : ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " -> ");
        }
        System.out.println("END");

        System.out.print("Backward Traversal: ");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " <- ");
        }
        System.out.println("START");

        // 4. Functional Stream / forEach Iteration [O(N) Time]
        System.out.println("\n--- 4. Lambda forEach Iteration (Java 8+) ---");
        techStack.forEach(tech -> System.out.println("Technology: " + tech));

        printSummary();
    }

    private static void printSummary() {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("📊 TIME & SPACE COMPLEXITY ANALYSIS (Iteration & Search)");
        System.out.println("----------------------------------------------------------");
        System.out.println("• Iteration Time Complexity   : O(N) [Visits N elements]");
        System.out.println("• Search Time Complexity      : O(N) [Linear equality checks]");
        System.out.println("• Iteration Space Complexity  : O(1) [Iterator object on stack]");
        System.out.println("• Safe Removal Mechanism      : iterator.remove() updates modCount");
        System.out.println("----------------------------------------------------------");
    }
}
