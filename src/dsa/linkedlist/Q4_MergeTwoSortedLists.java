package dsa.linkedlist;

/**
 * ============================================================
 *  Q4 - MERGE TWO SORTED LINKED LISTS
 *  🏢 Asked In: Amazon, Microsoft, Apple, Meta, Uber
 *  ⭐ Difficulty: Easy / Medium
 *  📌 Topic: Linked List + Two Pointers + Dummy Node
 * ============================================================
 *
 *  PROBLEM:
 *  Merge two sorted linked lists into one single sorted list.
 *  Example: L1: 1 -> 3 -> 5 | L2: 2 -> 4 -> 6 ==> Result: 1 -> 2 -> 3 -> 4 -> 5 -> 6
 *
 * ============================================================
 *  TIME & SPACE COMPLEXITY ANALYSIS
 * ============================================================
 *  Time Complexity  : O(N + M) -> Traversing through both lists once
 *  Space Complexity : O(1)     -> In-place relinking using a dummy node
 * ============================================================
 */
public class Q4_MergeTwoSortedLists {

    // OPTIMAL SOLUTION - Iterative with Dummy Head
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1); // Temp placeholder
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Attach leftover nodes directly
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next; // Head of newly merged list
    }

    public static void main(String[] args) {
        // List 1: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        // List 2: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);

        System.out.println("=== MERGE TWO SORTED LINKED LISTS ===");
        System.out.print("List 1      : ");
        Q1_ReverseLinkedList.printList(l1);
        System.out.print("List 2      : ");
        Q1_ReverseLinkedList.printList(l2);

        ListNode mergedHead = mergeTwoLists(l1, l2);

        System.out.print("Merged List : ");
        Q1_ReverseLinkedList.printList(mergedHead);
    }
}
