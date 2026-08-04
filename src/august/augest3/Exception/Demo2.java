package august.augest3.Exception;

public class Demo2 {
    public static int getNumber() {
        try {
            return 10; // This value gets evaluated but overridden
        } finally {
            return 20; // This is the value that actually gets returned
        }
    }

    public static void main(String[] args) {
        System.out.println(getNumber()); // Outputs: 20
    }
}
