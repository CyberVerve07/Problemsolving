package Collection.Linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * ============================================================
 *  CODE 4 - BIDIRECTIONAL TRAVERSAL USING LISTITERATOR
 *  🏢 Asked In: Oracle, Cisco, Walmart, Infosys
 *  ⭐ Topic: ListIterator & Safe Modification during Iteration
 * ============================================================
 *
 *  WHY ListIterator?
 *  - Standard Iterator only moves forward (`next()`).
 *  - ListIterator moves BOTH forward (`next()`) and backward (`previous()`).
 *  - Safely modifies/removes elements without ConcurrentModificationException!
 *
 * ============================================================
 *  TIME & SPACE COMPLEXITY ANALYSIS
 * ============================================================
 *  Time Complexity  : O(N) -> Single pass traversal
 *  Space Complexity : O(1) -> Iterator instance cursor memory
 * ============================================================
 */
public class Code4_LinkedListListIterator {

    public static void main(String[] args) {
        LinkedList<String> techStack = new LinkedList<>();
        techStack.add("Java");
        techStack.add("Spring Boot");
        techStack.add("Microservices");
        techStack.add("Docker");

        System.out.println("=== 1. FORWARD TRAVERSAL & MODIFICATION ===");
        ListIterator<String> itr = techStack.listIterator();

        while (itr.hasNext()) {
            String item = itr.next();
            if (item.equals("Docker")) {
                itr.set("Kubernetes"); // Safe replace in O(1)
            }
        }
        System.out.println("Updated Stack: " + techStack);

        System.out.println("\n=== 2. BACKWARD TRAVERSAL ===");
        System.out.print("Reverse Order: ");
        while (itr.hasPrevious()) {
            System.out.print(itr.previous() + " | ");
        }
        System.out.println();
    }
}
