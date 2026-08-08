package august.augest8;

class Demo4 {
    static void check() throws Exception {
        throw new Exception("Java");
    }

    public static void main(String[] args) {
        try {
            check();
            System.out.println("A");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("B");
    }
}
