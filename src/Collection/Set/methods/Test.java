package Collection.Set.methods;

public class Test {
    public static void main(String[] args) {
        // Do alag objects banaye same data ke sath
        Demo1 demo1 = new Demo1("Aditya", "890", 300);
        Demo1 demo2 = new Demo1("Aditya", "890", 300);

        // Print karke check kar rahe hain
        System.out.println("Hash code of demo1: " + demo1.hashCode());
        System.out.println("Hash code of demo2: " + demo2.hashCode());

        // Yeh true batayega kyunki data same hai
        System.out.println("Are they equal? " + demo1.equals(demo2));
    }
}