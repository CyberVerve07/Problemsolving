package august.augest22;

class Parent {
    void show(Object o) {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    @Override
    void show(Object o) {
        System.out.println("Child");
    }

    void show(String s) {
        System.out.println("String");
    }
}

public class Question11 {
    public static void main(String[] args) {
        Parent p = new Child();
        p.show("Java");
    }
}