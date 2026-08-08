package august.augest8;

class Test {
    static void test() {
        try {
            System.out.println("A");
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("B");
            throw e;
        } finally {
            System.out.println("C");
        }
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (RuntimeException e) {
            System.out.println("D");
        }
    }
}
