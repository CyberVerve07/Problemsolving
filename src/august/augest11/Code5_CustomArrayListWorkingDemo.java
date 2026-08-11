package august.augest11;

import java.util.Arrays;

/**
 * ----------------------------------------------------------------------------------
 * 📌 CODE 5: Custom Implementation of ArrayList (MyArrayList<T>) From Scratch
 * ----------------------------------------------------------------------------------
 *
 * 🔍 PURPOSE OF THIS CLASS:
 * This class builds a mini-ArrayList from scratch to demonstrate the EXACT internal
 * data structure, resizing logic, and memory layout used by java.util.ArrayList!
 *
 * 🏗️ KEY INTERNAL COMPONENTS IMPLEMENTED:
 * 1. `Object[] elementData`: Underlying raw contiguous memory array.
 * 2. `int size`            : Tracks count of user elements currently stored.
 * 3. `DEFAULT_CAPACITY = 10`: Default starting size of internal array.
 * 4. 1.5x Resizing Algorithm: `int newCapacity = oldCapacity + (oldCapacity >> 1)`.
 * 5. Bounds Checking        : Throws `IndexOutOfBoundsException` if index is invalid.
 * 6. Element Shifting       : Uses `System.arraycopy()` for fast native memory shifting.
 *
 * ----------------------------------------------------------------------------------
 * ⏱️ TIME & SPACE COMPLEXITY ANALYSIS:
 * ----------------------------------------------------------------------------------
 * | Method            | Time Complexity | Space Complexity |
 * |-------------------|-----------------|------------------|
 * | `add(T e)`        | Amortized O(1)  | O(1) auxiliary   |
 * | `get(int index)`  | O(1)            | O(1)             |
 * | `set(index, val)` | O(1)            | O(1)             |
 * | `remove(index)`   | O(N)            | O(1)             |
 * | `size()`          | O(1)            | O(1)             |
 * ----------------------------------------------------------------------------------
 *
 * @author Aditya
 * @date 11th August
 */
class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    /**
     * Constructor initializing internal array with default capacity 10.
     */
    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Constructor initializing internal array with specified initial capacity.
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
        this.size = 0;
    }

    /**
     * Adds element to the end of list.
     * Time Complexity: Amortized O(1)
     */
    public void add(T element) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = element;
    }

    /**
     * Internal capacity check & 1.5x growth algorithm.
     */
    private void ensureCapacityInternal(int minCapacity) {
        if (minCapacity > elementData.length) {
            int oldCapacity = elementData.length;
            // Growth Formula: 1.5x (oldCapacity + oldCapacity / 2)
            int newCapacity = oldCapacity + (oldCapacity >> 1);

            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }

            System.out.println("   [INTERNAL RESIZE] Growing capacity from " + oldCapacity + " -> " + newCapacity);
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    /**
     * Access element by index.
     * Time Complexity: O(1)
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        rangeCheck(index);
        return (T) elementData[index];
    }

    /**
     * Removes element at specified index and shifts remaining elements left.
     * Time Complexity: O(N)
     */
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        rangeCheck(index);

        T oldValue = (T) elementData[index];
        int numMoved = size - index - 1;

        if (numMoved > 0) {
            // Shift elements to the left
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }

        elementData[--size] = null; // Clear to let GC work
        return oldValue;
    }

    /**
     * Returns number of elements.
     * Time Complexity: O(1)
     */
    public int size() {
        return size;
    }

    /**
     * Returns internal array length (capacity).
     */
    public int getCapacity() {
        return elementData.length;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Code5_CustomArrayListWorkingDemo {

    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("   DEMO 5: CUSTOM MYARRAYLIST<T> FROM SCRATCH             ");
        System.out.println("==========================================================\n");

        // Create Custom ArrayList
        MyArrayList<String> customList = new MyArrayList<>(3); // Starting with small capacity 3 to demonstrate resize
        System.out.println("Created MyArrayList with initial capacity = 3");
        System.out.println("Initial Size: " + customList.size() + " | Internal Capacity: " + customList.getCapacity() + "\n");

        // Adding elements to trigger resize
        System.out.println("Adding elements:");
        customList.add("Apple");
        customList.add("Banana");
        customList.add("Cherry");
        System.out.println("List: " + customList + " | Size: " + customList.size() + " | Capacity: " + customList.getCapacity());

        System.out.println("\nAdding 4th element ('Date') -> Should trigger 1.5x resize!");
        customList.add("Date");
        System.out.println("List: " + customList + " | Size: " + customList.size() + " | Capacity: " + customList.getCapacity());

        // Accessing element: get(2) -> O(1)
        System.out.println("\nget(2) [O(1) Direct Access]: " + customList.get(2));

        // Removing element: remove(1) -> O(N) Left Shift
        System.out.println("\nremove(1) [O(N) Left Shift]: Removing 'Banana'...");
        String removed = customList.remove(1);
        System.out.println("Removed: " + removed);
        System.out.println("List after removal: " + customList + " | Size: " + customList.size());

        printFinalSummary();
    }

    private static void printFinalSummary() {
        System.out.println("\n----------------------------------------------------------");
        System.out.println("📊 FINAL RECAP: ARRAYLIST INTERNAL ARCHITECTURE");
        System.out.println("----------------------------------------------------------");
        System.out.println("1. Dynamic Array  : Backed by raw Object[] array.");
        System.out.println("2. Resize Growth  : 1.5x (oldCapacity + (oldCapacity >> 1)).");
        System.out.println("3. Direct Access  : O(1) indexed lookup.");
        System.out.println("4. Insert/Delete  : O(N) due to array shift using System.arraycopy().");
        System.out.println("----------------------------------------------------------");
    }
}
