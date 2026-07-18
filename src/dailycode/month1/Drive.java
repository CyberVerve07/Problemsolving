package dailycode.month1;

class Test {

    void show(Object obj) {
        System.out.println("Object");
    }

    void show(String str) {
        System.out.println("String");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.show(null);
    }
}
