package august.augest8;

 class Demo3 {
    static int count = 0;

    static void test() {
        count++;

        if (count < 3) {
            test();
        }

        System.out.print(count + " ");
    }

    public static void main(String[] args) {
        test();
    }
}