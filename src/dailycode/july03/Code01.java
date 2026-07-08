package dailycode.july03;

public class Code01 {
    public static void main(String[] args) {
        String name="Aditya";
        String name2="Rohit";

         String obj1=new String(" Aditya").intern();


        System.out.println(obj1);

    }

    public class Main {
        public static void main(String[] args) {
            String s1 = new String("GFG"); // Heap
            String s2 = s1.intern(); // SCP
            String s3 = "GFG"; // SCP
            System.out.println(s1 == s2); //  (Heap vs SCP)
            System.out.println(s2 == s3); // (Both in SCP)
        }
    }
}
