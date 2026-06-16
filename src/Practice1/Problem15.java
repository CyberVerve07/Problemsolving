 class Test {

    static void change(int x) {
        x = 50;
    }
    public static void main(String[] args) {

        int num = 10;

        change(num);

        System.out.println(num);
    }
}