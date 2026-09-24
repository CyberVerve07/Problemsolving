package MultiThreading;

class Demo19 {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("T1: " + i);
                Thread.yield();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("T2: " + i);
            }
        });

        t1.start();
        t2.start();
    }
}