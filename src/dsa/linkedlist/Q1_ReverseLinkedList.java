package dsa.linkedlist;

/**
 * ============================================================
 *  Q1 - REVERSE A LINKED LIST
 *  🏢 Asked In: Amazon, Microsoft, Google, Meta, Flipkart
 *  ⭐ Difficulty: Easy
 *  📌 Topic: Linked List (Pointers)
 * ============================================================
 *
 *  PROBLEM:
 *  Given head of a singly linked list, reverse the list and return its new head.
 *  Example: 1 -> 2 -> 3 -> 4 -> 5  ==>  5 -> 4 -> 3 -> 2 -> 1
 *
 * ============================================================
 *  TIME & SPACE COMPLEXITY ANALYSIS
 * ============================================================
 *  Time Complexity  : O(N) -> Single pass traversing N nodes
 *  Space Complexity : O(1) -> In-place pointer manipulation
 * ============================================================
 */

// Package-private Node class shared across package dsa.linkedlist
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Q1_ReverseLinkedList {

    // OPTIMAL SOLUTION - Iterative 3-Pointer Approach
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // 1. Store next node
            curr.next = prev;              // 2. Reverse link direction
            prev = curr;                   // 3. Move prev one step forward
            curr = nextTemp;               // 4. Move curr one step forward
        }

        return prev; // prev is now the new head of reversed list
    }

    public static void main(String[] args) {
        // Create List: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("=== REVERSE LINKED LIST ===");
        System.out.print("Original List : ");
        printList(head);

        ListNode reversedHead = reverseList(head);

        System.out.print("Reversed List : ");
        printList(reversedHead);
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }
}
