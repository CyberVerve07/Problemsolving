package Collection.Map;

class Test {

    synchronized void instanceMethod() {
        System.out.println("Instance");
    }

    static synchronized void staticMethod() {
        System.out.println("Static");
    }
}

 class Run{
     public static void main(String[] args) {
     Test obj1 = new Test();
     Test obj2 = new Test();

     Thread t1 = new Thread(() -> obj1.instanceMethod());
     Thread t2 = new Thread(() -> obj2.instanceMethod());

     Thread t3 = new Thread(() -> Test.staticMethod());
     Thread t4 = new Thread(() -> Test.staticMethod());
 }}