package Collection.Practice;
import java.util.*;
public class Demo1 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        System.out.print(list.poll() + " ");
        try {
            System.out.print(list.remove());
        } catch (NoSuchElementException e) {
            System.out.print("Exception");
        }
    }
}