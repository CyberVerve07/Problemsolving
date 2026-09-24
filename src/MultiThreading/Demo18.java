package MultiThreading;

class Demo18 {
    public static void main(String[] args) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread 1 still has lock");

    }



    synchronized void method1() throws InterruptedException {
        System.out.println("Thread 1 got lock");

//        Thread.sleep(5000);
//
//        System.out.println("Thread 1 still has lock");
    }

    synchronized void method2() {
        System.out.println("Thread 2 entered");
    }
}