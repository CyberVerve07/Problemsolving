package Java8.Lambda;

class Test implements MyInterface {

    @Override
    public void show() {
        System.out.println("Java 8 beautifully:");
    }

    public static void main(String[] args) {

        MyInterface obj = () -> System.out.println("Hello");

        obj.show();

    }
}