package MultiThreading;

public class Demo3 {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("Task 1");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Task 2");
        });

        t1.start();
        t2.start();
    }
}