//package MultiThreading;
//
//class Counter1 {
//    int count = 0;
//    void inc() {
//        count++;
//    }
//}
////Race conditions
////When the 2 thread are acessed and modified the share data concurrently and  final result is depending on the timing or the
////order of thread execution so in their we
////Atomicity ->Atomicity in multithreading means an operation executes completely as a single,
//// indivisible unit without any interruption or visible intermediate
////Synchronised ,Volatile
//
////Thread life cycle New->Runnable->Running->Waiting->Block->Runnable->Terminate the threes
//
//
//public class Demo9 {
//    public static void main(String[] args) throws InterruptedException {
//        Counter1 counter1 = new Counter1();
//
//        Thread t1 = new Thread(() -> {
//            for (int i = 1; i <= 10000; i++) {
//                counter1.inc();
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            for (int i = 1; i <= 10000; i++) {
//                counter1.inc();
//            }
//        });
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        // Will likely print a number less than 20000 due to race conditions
//        System.out.println("Final Count: " + counter1.count);
//    }
//}