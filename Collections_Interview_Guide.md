# Java Collection Framework (JCF) - Complete Interview Revision Guide

> **Target Audience:** Java Developers preparing for Technical Interviews (Fresher to Senior Level)  
> **Topic:** Java Collection Framework (Hierarchy, Internal Mechanics, Complexities, Multithreading & Top Q&A)

---

## 📌 Table of Contents
1. [Collection Framework Hierarchy](#1-collection-framework-hierarchy)
2. [List Interface & Implementations](#2-list-interface--implementations)
3. [Set Interface & Implementations](#3-set-interface--implementations)
4. [Queue & Deque Interfaces](#4-queue--deque-interfaces)
5. [Map Interface & Implementations](#5-map-interface--implementations)
6. [Deep Dive: How HashMap Works Internally](#6-deep-dive-how-hashmap-works-internally)
7. [Fail-Fast vs Fail-Safe Iterators](#7-fail-fast-vs-fail-safe-iterators)
8. [Comparable vs Comparator](#8-comparable-vs-comparator)
9. [Time & Space Complexity Cheatsheet](#9-time--space-complexity-cheatsheet)
10. [Top 25 Frequently Asked Interview Questions](#10-top-25-frequently-asked-interview-questions)

---

## 1. Collection Framework Hierarchy

The Java Collection Framework consists of two main root interfaces:
1. `java.util.Collection` (Single object elements)
2. `java.util.Map` (Key-Value pair elements - does *not* extend `Collection`)

```
                      Iterable<E>
                           |
                      Collection<E>
         /                 |                 \
     List<E>            Set<E>             Queue<E>
     /  |  \           /   |   \               |
    AL  LL  Vector   HS   LHS  TreeSet       Deque<E>
            |                       (NavigableSet) |  \
          Stack                                  ArrayDeque LL
```
*(AL: ArrayList, LL: LinkedList, HS: HashSet, LHS: LinkedHashSet)*

```
                       Map<K, V>
        /         /        |            \
    HashMap  Hashtable  LinkedHashMap  SortedMap<K,V>
       |          |                           |
  (Uses Nodes)  Vector-like              NavigableMap<K,V>
                (Legacy)                      |
                                           TreeMap<K,V>
```

---

## 2. List Interface & Implementations

Lists preserve **insertion order** and allow **duplicate elements**.

### 🔹 ArrayList
- **Underlying Data Structure:** Dynamic Array.
- **Initial Capacity:** `10` (when the first element is added).
- **Growth Formula:** `New Capacity = Old Capacity + (Old Capacity >> 1)` $\approx 1.5\times$ old capacity.
- **Access Time:** $O(1)$ by index.
- **Insertion/Deletion:** $O(n)$ worst case (due to array shift operations).
- **Thread Safety:** Not synchronized.

### 🔹 LinkedList
- **Underlying Data Structure:** Doubly Linked List.
- **Features:** Implements both `List` and `Deque` interfaces.
- **Access Time:** $O(n)$ (must traverse nodes).
- **Insertion/Deletion:** $O(1)$ if node pointer is known/at ends; $O(n)$ if searching position.
- **Memory Overhead:** Higher than ArrayList due to `Node` object creation (stores `item`, `next`, `prev`).

### 🔹 Vector & Stack (Legacy)
- **Vector:** Dynamic array similar to `ArrayList`, but **synchronized** (thread-safe). Grows by $2\times$ (100%). Slow due to lock acquisition.
- **Stack:** Extends `Vector`. Follows LIFO (Last-In-First-Out). *Recommendation:* Use `ArrayDeque` instead of `Stack`.

### ⚖️ Comparison: ArrayList vs LinkedList vs Vector

| Feature | ArrayList | LinkedList | Vector |
| :--- | :--- | :--- | :--- |
| **Data Structure** | Dynamic Array | Doubly Linked List | Dynamic Array |
| **Random Access** | $O(1)$ | $O(n)$ | $O(1)$ |
| **Insert/Delete** | $O(n)$ (Shifting) | $O(1)$ (Pointer adjustment) | $O(n)$ |
| **Thread Safe** | ❌ No | ❌ No | ✅ Yes (Synchronized) |
| **Growth Factor** | 50% ($1.5\times$) | N/A (Node based) | 100% ($2\times$) |

---

## 3. Set Interface & Implementations

Sets do **not allow duplicate elements**.

### 🔹 HashSet
- **Underlying Data Structure:** `HashMap` (stores element as Key, dummy object `PRESENT` as Value).
- **Ordering:** No guaranteed iteration order.
- **Null values:** Allows at most **one `null` element**.
- **Operations:** $O(1)$ average time complexity for `add`, `remove`, `contains`.

### 🔹 LinkedHashSet
- **Underlying Data Structure:** `HashMap` + Doubly Linked List running through all entries.
- **Ordering:** Maintains **Insertion Order**.
- **Performance:** Slightly slower than `HashSet` due to maintaining linked list pointers, but iteration is faster.

### 🔹 TreeSet
- **Underlying Data Structure:** Red-Black Tree (Self-Balancing BST).
- **Ordering:** **Sorted Order** (Natural order or via custom `Comparator`).
- **Null values:** Does **NOT** allow `null` (throws `NullPointerException` in Java 7+ during comparison).
- **Operations:** $O(\log n)$ for `add`, `remove`, `contains`.

---

## 4. Queue & Deque Interfaces

Designed for holding elements prior to processing.

### 🔹 PriorityQueue
- **Data Structure:** Binary Min-Heap (default).
- **Ordering:** Elements ordered according to natural ordering or custom `Comparator`.
- **Null values:** `null` is **not permitted**.
- **Key Operations:** `offer()` ($O(\log n)$), `poll()` ($O(\log n)$), `peek()` ($O(1)$).

### 🔹 ArrayDeque
- **Data Structure:** Resizable array-based Double-Ended Queue.
- **Features:** Faster than `Stack` (when used as stack) and faster than `LinkedList` (when used as queue).
- **Memory:** No allocation overhead of node objects. `null` elements disallowed.

---

## 5. Map Interface & Implementations

Maps store data in **Key-Value pairs**. Keys must be unique.

### 🔹 HashMap
- **Underlying Structure:** Hash Table (Array of Buckets + LinkedList / Red-Black Tree).
- **Null Keys/Values:** Allows **1 null key** and **multiple null values**.
- **Thread Safety:** Not thread-safe.

### 🔹 LinkedHashMap
- **Underlying Structure:** `HashMap` with a doubly-linked list.
- **Features:** Preserves **Insertion Order** or **Access Order** (useful for building LRU Caches).

### 🔹 TreeMap
- **Underlying Structure:** Red-Black Tree.
- **Ordering:** Keys are **Sorted**.
- **Operations:** $O(\log n)$ time for search, insertion, deletion.

### 🔹 ConcurrentHashMap
- **Thread Safety:** Highly concurrent and thread-safe.
- **Java 7 vs Java 8+ Implementation:**
  - *Java 7:* Used **Segment Locking** (ReentrantLock per Segment; default concurrency level 16).
  - *Java 8+:* Uses **Bucket-level Locking** (`synchronized` on individual bucket head node + CAS operations). No segment locks!
- **Null values:** Disallows `null` keys and `null` values (to avoid ambiguity in concurrent environments).

---

## 6. Deep Dive: How HashMap Works Internally

This is the **#1 favorite topic of Java interviewers**.

### 🛠️ Internal Data Structure
`HashMap` uses an array of `Node<K,V>` called buckets:
```java
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;
}
```

### ⚙️ Important Constants
- **Initial Capacity:** `16` (`1 << 4`)
- **Maximum Capacity:** `2^30` (`1 << 30`)
- **Load Factor:** `0.75` (Default tradeoff between time & space complexity)
- **Threshold:** `Capacity * Load Factor` (e.g., $16 \times 0.75 = 12$). When size exceeds 12, it rehashes.
- **TREEIFY_THRESHOLD:** `8` (Converts bucket linked list to Red-Black Tree).
- **UNTREEIFY_THRESHOLD:** `6` (Converts tree back to linked list during resize).
- **MIN_TREEIFY_CAPACITY:** `64` (Bucket treeification only happens if total table capacity $\ge 64$; otherwise, it just resizes).

---

### 🔄 How `put(K key, V value)` Works Step-by-Step

1. **Calculate Hash:**
   ```java
   int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16); // XOR higher bits to reduce collisions
   ```
2. **Calculate Bucket Index:**
   ```java
   int index = (n - 1) & hash; // Equivalent to hash % n, but faster because n is power of 2
   ```
3. **Handle Bucket Placement:**
   - **Case A (Bucket is Empty):** Create new `Node` and place it at index.
   - **Case B (Bucket has existing Node - Collision):**
     - Iterate through linked list using `.equals(key)`.
     - If key exists: Replace existing value.
     - If key does not exist: Append new `Node` at the end of the list.
   - **Case C (Treeification):** If linked list length reaches `8` AND table capacity $\ge 64$, convert list to **TreeNode (Red-Black Tree)**. Time complexity improves from $O(n)$ to $O(\log n)$.
4. **Check Threshold & Resize:** If total element count exceeds `Threshold`, array doubles in size ($16 \to 32$), and rehashing occurs.

---

## 7. Fail-Fast vs Fail-Safe Iterators

| Feature | Fail-Fast Iterator | Fail-Safe Iterator |
| :--- | :--- | :--- |
| **Behavior** | Throws `ConcurrentModificationException` immediately if collection is modified while iterating. | Does **NOT** throw exception if collection is modified during iteration. |
| **Mechanism** | Checks internal counter `modCount` before every `next()`. | Operates on a **clone/copy** or concurrent data view. |
| **Examples** | `ArrayList`, `HashSet`, `HashMap`, `Vector` iterators | `CopyOnWriteArrayList`, `ConcurrentHashMap` iterators |
| **Performance** | High efficiency, low memory | Slight overhead due to copying underlying data |

---

## 8. Comparable vs Comparator

```java
// 1. Comparable (Natural Sorting - Single Sorting Logic inside the class)
public class Student implements Comparable<Student> {
    int rollNo;
    String name;

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.rollNo, o.rollNo); // Ascending order by rollNo
    }
}

// Usage: Collections.sort(studentList);
```

```java
// 2. Comparator (Custom Sorting - Multiple Sorting Logics outside the class)
Comparator<Student> nameComparator = (s1, s2) -> s1.name.compareTo(s2.name);
Comparator<Student> ageThenName = Comparator.comparingInt((Student s) -> s.age)
                                           .thenComparing(s -> s.name);

// Usage: Collections.sort(studentList, nameComparator);
```

| Feature | `Comparable` | `Comparator` |
| :--- | :--- | :--- |
| **Package** | `java.lang` | `java.util` |
| **Method** | `compareTo(Object o)` | `compare(Object o1, Object o2)` |
| **Modifies Class?** | Yes (Class must implement interface) | No (External class/lambda) |
| **Sorting Options** | Single natural sorting logic | Multiple custom sorting logics |

---

## 9. Time & Space Complexity Cheatsheet

| Collection | Access (Search by Index) | Search (by Value) | Insert | Delete | Space Complexity |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **ArrayList** | $O(1)$ | $O(n)$ | $O(1)$ amortized, $O(n)$ worst | $O(n)$ | $O(n)$ |
| **LinkedList** | $O(n)$ | $O(n)$ | $O(1)$ | $O(1)$ | $O(n)$ |
| **HashSet / HashMap** | N/A | $O(1)$ avg, $O(\log n)$ worst | $O(1)$ avg, $O(\log n)$ worst | $O(1)$ avg | $O(n)$ |
| **TreeSet / TreeMap** | N/A | $O(\log n)$ | $O(\log n)$ | $O(\log n)$ | $O(n)$ |
| **PriorityQueue** | N/A | $O(n)$ | $O(\log n)$ | $O(\log n)$ | $O(n)$ |
| **ArrayDeque** | $O(1)$ at ends | $O(n)$ | $O(1)$ | $O(1)$ | $O(n)$ |

---

## 10. Top 25 Frequently Asked Interview Questions

### Q1: Why does HashMap bucket capacity always need to be a power of 2?
> **Answer:** To optimize index calculation! `hash % capacity` is mathematically equivalent to `(capacity - 1) & hash` ONLY when capacity is a power of 2. Bitwise AND `&` is much faster than the modulo division operator `%` on CPUs.

### Q2: What happens if two distinct keys produce the exact same `hashCode()`?
> **Answer:** This is called a **Hash Collision**. Both key-value pairs are stored in the same array bucket as nodes of a linked list (or Red-Black tree). During `get(key)`, HashMap uses `hashCode()` to find the bucket, then uses `.equals(key)` to find the exact key-value pair.

### Q3: Why must `equals()` and `hashCode()` contracts be maintained?
> **Answer:** If two objects are equal according to `equals()`, they **MUST** return the exact same `hashCode()`. If broken, HashMap will store equal keys in different buckets or fail to locate an existing key during `get()`.

### Q4: Why are immutable objects (like String, Integer) ideal as HashMap keys?
> **Answer:** If a mutable key's state changes after insertion into a HashMap, its `hashCode()` changes. HashMap will calculate a different bucket index during `get()`, resulting in data loss / inability to retrieve the value. Also, `String` caches its hash code, making it fast.

### Q5: Difference between `poll()` and `remove()` in Queue?
> **Answer:** Both retrieve and remove the head of the queue. However, if the queue is empty:
> - `poll()` returns `null`.
> - `remove()` throws `NoSuchElementException`.

### Q6: Difference between `peek()` and `element()` in Queue?
> **Answer:** Both examine the head without removing it.
> - `peek()` returns `null` if empty.
> - `element()` throws `NoSuchElementException` if empty.

### Q7: How to make an `ArrayList` unmodifiable/read-only?
> **Answer:**
> 1. `Collections.unmodifiableList(existingList)` (Throws `UnsupportedOperationException` on modification).
> 2. `List.of("A", "B", "C")` (Java 9+ immutable list).

### Q8: How to make an `ArrayList` synchronized?
> **Answer:** Use `List<String> synList = Collections.synchronizedList(new ArrayList<>());`. Always synchronize manually when iterating over it!

### Q9: Difference between `HashMap` and `Hashtable`?
> **Answer:**
> - `HashMap` is unsynchronized, allows 1 null key and multiple null values, and was introduced in Java 1.2.
> - `Hashtable` is synchronized (legacy class from Java 1.0), and disallows null keys or values.

### Q10: How does `CopyOnWriteArrayList` achieve thread safety?
> **Answer:** Every write operation (`add`, `set`, `remove`) makes a **fresh copy** of the underlying array. Iterators operate on the old immutable snapshot, preventing `ConcurrentModificationException` without needing explicit synchronization. Ideal for read-heavy, write-rare scenarios.

### Q11: What is the difference between `Collection` and `Collections`?
> **Answer:** 
> - `Collection` is an **Interface** (`java.util.Collection`).
> - `Collections` is an **Utility Class** (`java.util.Collections`) containing static methods like `sort()`, `binarySearch()`, `reverse()`, `unmodifiableList()`.

### Q12: What is the difference between `SynchronizedMap` and `ConcurrentHashMap`?
> **Answer:**
> - `SynchronizedMap` locks the **entire map** for every operation (poor throughput under high concurrency).
> - `ConcurrentHashMap` locks only the **specific bucket node** involved in writing (high concurrency).

### Q13: What happens when an `ArrayList` reaches maximum capacity?
> **Answer:** It creates a new array of size `oldCapacity + (oldCapacity >> 1)`, copies all elements using `Arrays.copyOf()`, and points the reference to the new array.

### Q14: How does `HashSet` check for duplicates internally?
> **Answer:** `HashSet` invokes `map.put(element, PRESENT)`. Inside `HashMap.put()`, it calculates `hashCode()`. If a matching hash bucket exists, it invokes `.equals()`. If `.equals()` returns `true`, the old value is overwritten and false/duplicate status is recognized.

### Q15: What is the initial capacity and load factor of HashMap?
> **Answer:** Initial capacity = `16`, Default Load Factor = `0.75`. Rehash Threshold = $16 \times 0.75 = 12$.

### Q16: When does a LinkedList perform better than an ArrayList?
> **Answer:** When frequent insertions/deletions occur at the **beginning or middle** of the collection, and random index access is not required.

### Q17: What is `IdentityHashMap`?
> **Answer:** A special Map implementation that uses **reference equality (`==`)** instead of object equality (`.equals()`) when comparing keys.

### Q18: What is `WeakHashMap`?
> **Answer:** A Map implementation where keys are wrapped in `WeakReference`. If a key object is no longer referenced elsewhere, GC automatically reclaims it and removes the entry from the map. Useful for memory caches.

### Q19: What is `EnumMap`?
> **Answer:** A specialized, extremely fast `Map` designed exclusively for `Enum` keys. Internally represented as a compact single array indexed by enum ordinal.

### Q20: Why can't we insert `null` into a `TreeSet` or `TreeMap`?
> **Answer:** Because elements are sorted using `compareTo()` or `compare()`. Invoking `.compareTo()` on `null` causes a `NullPointerException`.

### Q21: What is the difference between `Iterator` and `ListIterator`?
> **Answer:**
> - `Iterator` traverses only forward, works on any `Collection`.
> - `ListIterator` traverses **both forward and backward**, works **only on List implementations**, and can modify elements (`add`, `set`).

### Q22: What is the difference between `ArrayDeque` and `LinkedList` for Stack/Queue operations?
> **Answer:** `ArrayDeque` is faster and more memory-efficient because it does not allocate `Node` objects for each element and doesn't incur GC pressure like `LinkedList`.

### Q23: What changes were introduced in Java 8 HashMap for worst-case lookup?
> **Answer:** Before Java 8, worst-case collision lookup in a bucket was $O(n)$ (LinkedList). In Java 8+, if a bucket has $\ge 8$ elements and capacity $\ge 64$, it converts the LinkedList to a **Red-Black Tree**, reducing worst-case time to $O(\log n)$.

### Q24: What is `Collections.emptyList()` and why should we use it instead of `new ArrayList<>()`?
> **Answer:** `Collections.emptyList()` returns an immutable, shared singleton empty list instance without creating new objects in memory. It prevents unnecessary object creation when returning empty collections from methods.

### Q25: How to sort a Map by Value in Java 8+?
> **Answer:**
```java
Map<String, Integer> map = Map.of("A", 10, "B", 5, "C", 20);

Map<String, Integer> sortedMap = map.entrySet().stream()
    .sorted(Map.Entry.comparingByValue())
    .collect(Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue,
        (e1, e2) -> e1,
        LinkedHashMap::new // Preserves sorted order
    ));
```

---
*Created for Quick Revision & Interview Prep.*
