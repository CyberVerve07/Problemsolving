package dsa.linkedlist;

/**
 * ============================================================
 *  Q5 - REMOVE Nth NODE FROM END OF LINKED LIST
 *  🏢 Asked In: Google, Amazon, Facebook, Microsoft, PayTM
 *  ⭐ Difficulty: Medium
 *  📌 Topic: Linked List + Two Pointers + Single Pass
 * ============================================================
 *
 *  PROBLEM:
 *  Given head of a linked list, remove the Nth node from the end in ONE PASS.
 *  Example: 1 -> 2 -> 3 -> 4 -> 5, n = 2  ==>  1 -> 2 -> 3 -> 5
 *
 * ============================================================
 *  TIME & SPACE COMPLEXITY ANALYSIS
 * ============================================================
 *  Time Complexity  : O(N) -> Single pass traversal
 *  Space Complexity : O(1) -> Constant auxiliary memory
 * ============================================================
 */
public class Q5_RemoveNthFromEnd {

    // OPTIMAL SOLUTION - Fast & Slow Pointer with N-step Gap
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast pointer n+1 steps ahead to create space gap
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both until fast reaches null
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Unlink the Nth node from end
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        // List: 1 -> 2 -> 3 -> 4 -> 5, n = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;
        System.out.println("=== REMOVE Nth NODE FROM END ===");
        System.out.print("Original List          : ");
        Q1_ReverseLinkedList.printList(head);

        ListNode updatedHead = removeNthFromEnd(head, n);

        System.out.print("After Removing (" + n + "nd from end): ");
        Q1_ReverseLinkedList.printList(updatedHead);
    }
}
