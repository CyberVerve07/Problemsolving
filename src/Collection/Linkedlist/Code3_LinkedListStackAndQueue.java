package Collection.Linkedlist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;

/**
 * ============================================================
 *  CODE 3 - LINKEDLIST AS STACK (LIFO) & QUEUE (FIFO)
 *  🏢 Asked In: Amazon, Microsoft, Samsung, PayTM
 *  ⭐ Topic: Deque & Queue Interfaces using LinkedList
 * ============================================================
 *
 *  INTERVIEW NOTE:
 *  LinkedList implements both Queue and Deque interfaces!
 *  - Queue operations: offer() [enqueue], poll() [dequeue], peek()
 *  - Stack operations: push() [push], pop() [pop], peek()
 *
 * ============================================================
 *  TIME & SPACE COMPLEXITY ANALYSIS
 * ============================================================
 *  | Data Structure Role | Operation       | Time | Space |
 *  |---------------------|-----------------|------|-------|
 *  | Queue (FIFO)        | offer() / poll()| O(1) | O(1)  |
 *  | Stack (LIFO)        | push() / pop()  | O(1) | O(1)  |
 * ============================================================
 */
public class Code3_LinkedListStackAndQueue {

    public static void main(String[] args) {
        System.out.println("=== 1. LINKEDLIST AS QUEUE (FIFO) ===");
        Queue<String> queue = new LinkedList<>();
        queue.offer("Customer 1"); // Enqueue: O(1)
        queue.offer("Customer 2");
        queue.offer("Customer 3");

        System.out.println("Queue Peek (Front) : " + queue.peek()); // O(1)
        System.out.println("Served (Poll)      : " + queue.poll()); // O(1)
        System.out.println("Remaining Queue    : " + queue);

        System.out.println("\n=== 2. LINKEDLIST AS STACK (LIFO) ===");
        Deque<String> stack = new LinkedList<>();
        stack.push("Page A"); // Push: O(1)
        stack.push("Page B");
        stack.push("Page C");

        System.out.println("Stack Top (Peek)   : " + stack.peek()); // O(1)
        System.out.println("Popped Element     : " + stack.pop());  // O(1)
        System.out.println("Remaining Stack    : " + stack);
    }
}
