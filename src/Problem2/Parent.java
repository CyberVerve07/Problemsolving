package Problem2;
class Parent {

    static {
        System.out.println("Parent SIB");
    }

    {
        System.out.println("Parent IIB");
    }
    //Default Constructor ::

    Parent() {
        System.out.println("Parent Constructor");
    }
}

class Child extends Parent {

    static {
        System.out.println("Child SIB");
    }

    { // Instance
        System.out.println("Child IIB");
    }

    Child() {
        System.out.println("Child Constructor");
    }

    void display() { //Method

        System.out.println("Method Called");
    }
}
class Main {

    public static void main(String[] args) {

        Child a = new Child();

        a.display();
    }
}