package dailycode.month1.day27;

class Code10 {

    public static void main(String[] args) {
        System.out.println("Original Main");

        main(10);
        main("Hello");
    }

    public static void main(int x) {
        System.out.println("Main with int: " + x);
    }

    public static void main(String msg) {
        System.out.println("Main with String: " + msg);
    }
}