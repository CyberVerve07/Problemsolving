package Collections.Linkedlist;

import java.util.LinkedList;

public class Demo1 {
    public static void main(String[] args) {

        System.out.println("Demo of linked  list");
        System.out.println("LinkedList is a data structure that stores elements in a linear order." +
                " It is a collection of nodes, where each node contains a reference to the next node in the sequence. " +
                "LinkedList allows for efficient insertion and deletion of elements, as it does not require shifting elements like an array-based list. However," +
                " accessing elements by index can be slower compared to an array-based list, as it requires traversing the list from the beginning to reach the desired index.");
           //linked list -> node
        //linked list is not index based it follows the node structure
        //previous address and next address is stored in the node
        LinkedList<String> list = new LinkedList<>();   //Create a new linked list
        list.add("Aditya");
        list.add("Shiva");
        list.add("Kartik");
        list.add("Rohit");
        //Ordered and allowed duplicate values
        System.out.println(list);
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.get(2));  //0(n)  because it is traverse //Reading the element
        System.out.println(list.size());
        System.out.println(list.contains("Aditya")); //it returns the Boolean value

        //Adding element O(1)+o(n)=O(N)
    }
    }

    //in these cases we got the O(1) time Complexity :
//addFirst(E e) / push(E e): Adds an element to the front of the list.addLast(E e) /
// add(E e): Adds an element to the end of the list.removeFirst() / pop():
// Removes and returns the first element.removeLast():
// Removes and returns the last element.getFirst() / peekFirst():
// Retrieves the first element without removing it.getLast() / peekLast():
// Retrieves the last element without removing it.