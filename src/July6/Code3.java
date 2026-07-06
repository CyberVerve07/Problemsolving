package July6;

public class Code3 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("Aditya ");// In String Builder only one obj is create and modift
        sb.append(" Gupta");
        System.out.println(sb);
        sb.append(" Learn Coding ");
        System.out.println(sb);// 3 obj 3 in scp and 1 in heap

        // Heap: 1 StringBuilder object  _>>>>>>>>>>>16
        // SCP: 3 String literals
        // append() modifies the same StringBuilder object
        //Buffer is and mutable  and threadSafe:
        //String Builder is not Thread safe ::
        //String is always thread safe : because it is immutable::


    }
}
