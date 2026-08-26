
package Collection.Set.methods;

public class Domain {
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1("Aditya", "890", 300);
        Demo1 demo2 = new Demo1("Aditya", "890", 300);

        System.out.println("Hash code of demo1 is: " + demo1.hashCode());
        System.out.println("Hash code of demo2 is: " + demo2.hashCode());
    }
}