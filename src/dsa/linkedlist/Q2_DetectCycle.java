package dsa.linkedlist;

/**
 * ============================================================
 *  Q2 - DETECT CYCLE IN LINKED LIST (FLOYD'S ALGORITHM)
 *  🏢 Asked In: Amazon, Microsoft, Samsung, TCS, Wipro
 *  ⭐ Difficulty: Easy
 *  📌 Topic: Linked List + Two Pointers (Slow & Fast)
 * ============================================================
 *
 *  PROBLEM:
 *  Determine if a linked list has a cycle in it.
 *  A cycle exists if a node can be reached again by continuously following next.
 *
 * ============================================================
 *  TIME & SPACE COMPLEXITY ANALYSIS
 * ============================================================
 *  Time Complexity  : O(N) -> Fast pointer travels at most 2N steps
 *  Space Complexity : O(1) -> Uses only two pointer references (slow & fast)
 * ============================================================
 */
public class Q2_DetectCycle {

    // OPTIMAL SOLUTION - Floyd's Cycle Detection (Tortoise and Hare)
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move 1 step
            fast = fast.next.next;   // Move 2 steps

            if (slow == fast) {
                return true;         // Cycle detected!
            }
        }

        return false;                // Reached null -> No cycle
    }

    public static void main(String[] args) {
        // Create List: 1 -> 2 -> 3 -> 4 -> (loop back to 2)
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Cycle created: 4 points back to 2

        System.out.println("=== CYCLE DETECTION IN LINKED LIST ===");
        boolean result = hasCycle(head);
        System.out.println("Has Cycle? " + result + " (Expected: true)");

        // Linear list test case: 10 -> 20 -> 30 -> null
        ListNode linear = new ListNode(10);
        linear.next = new ListNode(20);
        linear.next.next = new ListNode(30);

        boolean linearResult = hasCycle(linear);
        System.out.println("Linear List Has Cycle? " + linearResult + " (Expected: false)");
    }
}
