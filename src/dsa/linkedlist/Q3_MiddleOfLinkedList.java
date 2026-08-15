package dsa.linkedlist;

/**
 * ============================================================
 *  Q3 - FIND MIDDLE OF LINKED LIST
 *  🏢 Asked In: Adobe, Amazon, Qualcomm, Infosys, Tech Mahindra
 *  ⭐ Difficulty: Easy
 *  📌 Topic: Linked List + Fast & Slow Pointers (Runner Technique)
 * ============================================================
 *
 *  PROBLEM:
 *  Given head of a singly linked list, return the middle node.
 *  If there are two middle nodes (even length), return the second middle node.
 *
 * ============================================================
 *  TIME & SPACE COMPLEXITY ANALYSIS
 * ============================================================
 *  Time Complexity  : O(N) -> Single pass (fast pointer reaches end in N/2 steps)
 *  Space Complexity : O(1) -> Auxiliary memory constant
 * ============================================================
 */
public class Q3_MiddleOfLinkedList {

    // OPTIMAL SOLUTION - Runner Technique (Slow & Fast Pointer)
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Fast moves 2 steps, slow moves 1 step
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // Slow is at middle when fast reaches end
    }

    public static void main(String[] args) {
        System.out.println("=== FIND MIDDLE NODE OF LINKED LIST ===");

        // Test 1: Odd Length (1 -> 2 -> 3 -> 4 -> 5) -> Middle = 3
        ListNode oddHead = new ListNode(1);
        oddHead.next = new ListNode(2);
        oddHead.next.next = new ListNode(3);
        oddHead.next.next.next = new ListNode(4);
        oddHead.next.next.next.next = new ListNode(5);

        System.out.print("Odd List  : ");
        Q1_ReverseLinkedList.printList(oddHead);
        ListNode mid1 = findMiddle(oddHead);
        System.out.println("Middle Val: " + mid1.val + " (Expected: 3)\n");

        // Test 2: Even Length (10 -> 20 -> 30 -> 40) -> Second Middle = 30
        ListNode evenHead = new ListNode(10);
        evenHead.next = new ListNode(20);
        evenHead.next.next = new ListNode(30);
        evenHead.next.next.next = new ListNode(40);

        System.out.print("Even List : ");
        Q1_ReverseLinkedList.printList(evenHead);
        ListNode mid2 = findMiddle(evenHead);
        System.out.println("Middle Val: " + mid2.val + " (Expected: 30)");
    }
}
